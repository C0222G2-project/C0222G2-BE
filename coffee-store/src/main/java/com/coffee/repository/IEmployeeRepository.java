package com.coffee.repository;


import com.coffee.model.employee.Employee;
import com.coffee.dto.employe.IEmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * Create by TuyenTN
     * Date: 16:30 pm  9-8-2022
     * method show list and search and paging
     *
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
                    " and app_user.user_name like :keyTwo ) templol ", nativeQuery = true)
    Page<IEmployeeDTO> getAllEmployee(Pageable pageable, @Param("keyZero") String searchByName,
                                      @Param("keyOne") String searchByPhone,
                                      @Param("keyTwo") String searchByAccount);

    /**
     * Create by TuyenTN
     * Date: 16:30 pm  9-8-2022
     *
     * @param id
     * @return
     */
    @Query(value = "select employee.`name`,employee.phone_number as phoneNumber,position.name as position, " +
            " app_user.user_name as appUser,employee.id,employee.birthday,employee.image,employee.address,employee.salary, " +
            " employee.gender,employee.email from employee " +
            " join app_user on app_user.id = employee.user_id " +
            " join position on employee.position_id = position.id " +
            " where employee.is_deleted =0 and employee.id = :id ", nativeQuery = true)
    IEmployeeDTO findEmployeeById(Integer id);

    /**
     * Create by TuyenTN
     * Date: 16:30 pm  9-8-2022
     *
     * @param id
     * @return
     */
    @Transactional
    @Modifying
    @Query(value = " update employee set is_deleted = 1 where id = :id ", nativeQuery = true)
    void deleteEmployeeById(Integer id);

}
