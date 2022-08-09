package com.coffee.repository.account_employee;

import com.coffee.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountEmployeeRepository extends JpaRepository<Employee, Integer> {
}
