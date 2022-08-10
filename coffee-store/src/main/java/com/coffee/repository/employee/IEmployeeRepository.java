package com.coffee.repository.employee;

import com.coffee.dto.IEmployeeDto;
import com.coffee.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * @param
     * @return employee
     * @creator ThongNV
     * Date 10/08/2022
     */
    @Query(value = "select employee.image as image, app_user.user_name as userName," +
            " employee.name as nameEmployee, employee.address as address," +
            " employee.gender as gender, employee.phone_number as phoneNumber, employee.birthDay as birthDay," +
            " employee.salary as salary, position.name as positionName, employee.is_deleted as deleted " +
                "from employee " +
                "join app_user on employee.user_id = app_user.id " +
                "join position on employee.position_id = position.id " +
                "where employee.id = ?", nativeQuery = true)
    Optional<IEmployeeDto> findByEmployeeId(@Param("id") Integer id);


    /**
     * @param
     * @return new employee edited
     * @creator ThongNV
     * Date 10/08/2022
     */
    @Query(value = "")
    void updateAccount(Employee employee);

//    @Query(value = "select app_user.user_name as username " +
//            "from employee " +
//            "join app_user on employee.user_id = app_user.id " +
//            "join position on employee.position_id = position.id " +
//            "where employee.id = ?", nativeQuery = true)
//    EmployeeDTO test(@Param("id") Integer id);
}
