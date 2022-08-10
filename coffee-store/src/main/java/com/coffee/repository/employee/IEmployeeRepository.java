package com.coffee.repository.employee;

import com.coffee.dto.IAccountEmployeeDto;
import com.coffee.model.employee.Employee;
import com.coffee.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.sql.Date;


public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {


    /**
     * @param {id}
     * @return employee
     * @creator ThongNV
     * Date 10/08/2022
     */
    @Query(value = " select employee.id, employee.name, employee.image,employee.phone_number , employee.address , employee.email, employee.gender, " +
            " employee.birthday, employee.salary, employee.position_id , employee.user_id, employee.is_deleted from employee " +
            " join app_user on employee.user_id = app_user.id " +
            " join `position` on employee.position_id = `position`.id " +
            " where employee.id = id and employee.is_deleted = 0", nativeQuery = true)
    Employee findByIdEmployee();


    /**
     * @param name, @param image @param birthday  @param email @param gender @param phoneNumber @param address @param salary @param position
     * @return  true: employee ,edit employee success, status 200 / false: status 404
     * @creator ThongNV
     * Date 10/08/2022
     */
    @Transactional
    @Modifying
    @Query(value = " update employee set name= ?, image = ?, birthday = ?, email = ? , gender = ?, phone_number = ?,address = ?, " +
            " salary = ?, position_id = ? where id = :#{#employee.id}" , nativeQuery = true)
    Employee editEmployee(String name, String image, Date birthday, String email, Integer gender, String phoneNumber, String address, Double salary, Position position);
}
