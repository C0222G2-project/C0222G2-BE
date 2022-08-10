package com.coffee.repository.account_employee;

import com.coffee.dto.IAccountEmployeeDto;
import com.coffee.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAccountRepository extends JpaRepository<Employee, Integer> {
    /**
     * @param {id}
     * @return accountEmployeeDto
     * @creator ThongNV
     * Date 10/08/2022
     * this method find accountEmployeeDto by id
     */
    @Query(value = "select employee.image as employeeImage, app_user.user_name as employeeUserName," +
            " employee.name as employeeName, employee.address as employeeAddress," +
            " employee.gender as employeeGender, employee.phone_number as employeePhoneNumber, employee.birthDay as employeeBirthDay," +
            " employee.salary as employeeSalary, position.name as positionName " +
            "from employee " +
            "join app_user on employee.user_id = app_user.id " +
            "join position on employee.position_id = position.id " +
            "where employee.id = ?", nativeQuery = true)
    IAccountEmployeeDto findByAccountId(@Param("id") Integer id);
}
