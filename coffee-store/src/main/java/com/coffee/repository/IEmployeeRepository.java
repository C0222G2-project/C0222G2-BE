package com.coffee.repository;


import com.coffee.dto.employe.IEmployeeDTO;
import com.coffee.model.employee.Employee;
import com.coffee.model.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param employee
     * @return  create Employee success
     */
    @Modifying
    @Transactional
    @Query(value = " INSERT INTO employee (user_id, name, image, phone_number, address, email, gender, birthday, salary, position_id) " +
            " VALUES (:#{#employee.user.username}, :#{#employee.name}, :#{#employee.image}, :#{#employee.phoneNumber}, " +
            " :#{#employee.address}, :#{#employee.name}, :#{#employee.gender}, :#{#employee.birthday}, :#{#employee.salary}, " +
            " :#{#employee.position.id}); ", nativeQuery = true)
    Employee saveEmployee(@Param("employee") Employee employee);

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param name
     * @param image
     * @param birthday
     * @param email
     * @param gender
     * @param phoneNumber
     * @param address
     * @param salary
     * @param position
     * @return  create Employee success
     */
    @Transactional
    @Modifying
    @Query(value = " update employee set name= ?, image = ?, birthday = ?, email = ? , gender = ?, phone_number = ?,address = ?, " +
            " salary = ?, position_id = ? " , nativeQuery = true)
    Employee editEmployee(String name, String image, Date birthday , String email, int gender, String phoneNumber, String address, Double salary, Position position);

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param id
     * @return  object Employee
     */
    @Query(value = " select employee.id, employee.name, employee.image,employee.phone_number , employee.address " +
            " employee.email, employee.gender, employee.birthday, employee.salary, employee.position_id, employee.user_id " +
            " from employee join app_user on employee.user_id = app_user.id " +
            " join `position` on employee.position_id = `position`.id " +
            " where id = :id ", nativeQuery = true)
    Employee findByIdEmployee(Integer id);

    /**
     * Create by TuyenTN
     * Date: 16:30 pm  9-8-2022
     * method show list and search and paging
     * @param pageable
     * @param searchByName
     * @param searchByPhone
     * @param searchByAccount
     * @return
     */


    @Query(value = " select employee.`name`,employee.phone_number as phoneNumber,position.name as position, " +
            " app_user.user_name as appUser,employee.id,employee.birthday,employee.image,employee.address,employee.salary, " +
            " employee.gender,employee.email from employee " +
            " join app_user on app_user.id = employee.user_id " +
            " join position on employee.position_id = position.id " +
            " where employee.is_deleted =0 and employee.name like :keyZero and employee.phone_number like :keyOne " +
            " and app_user.user_name like :keyTwo ",
            countQuery = " select count(*) from (select employee.`name`,employee.phone_number as phoneNumber, " +
                    " app_user.user_name as appUser,position.name as position,employee.id,employee.birthday,employee.image, " +
                    " employee.address,employee.salary, employee.gender,employee.email from employee " +
                    " join app_user on app_user.id = employee.user_id " +
                    " join position on employee.position_id = position.id " +
                    " where employee.is_deleted =0 and employee.name like :keyZero and employee.phone_number like :keyOne " +
                    " and app_user.user_name like :keyTwo ) templol ",nativeQuery = true)
    Page<IEmployeeDTO> getAllEmployee(Pageable pageable, @Param("keyZero") String searchByName,
                                      @Param("keyOne") String searchByPhone,
                                      @Param("keyTwo") String searchByAccount);

    /**
     * Create by TuyenTN
     * Date: 16:30 pm  9-8-2022
     * @param id
     * @return
     */
    @Query(value = "select employee.`name`,employee.phone_number as phoneNumber,position.name as position, " +
            " app_user.user_name as appUser,employee.id,employee.birthday,employee.image,employee.address,employee.salary, " +
            " employee.gender,employee.email from employee " +
            " join app_user on app_user.id = employee.user_id " +
            " join position on employee.position_id = position.id " +
            " where employee.is_deleted =0 and employee.id = :id ",nativeQuery = true)
    IEmployeeDTO findEmployeeById(Integer id);

    /**
     * Create by TuyenTN
     * Date: 16:30 pm  9-8-2022
     * @param id
     * @return
     */
    @Transactional
    @Modifying
    @Query(value = " update employee set is_deleted = 1 where id = :id ",nativeQuery = true)
    void deleteEmployeeById(Integer id);


}
