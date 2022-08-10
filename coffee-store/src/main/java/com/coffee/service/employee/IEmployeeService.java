package com.coffee.service.employee;

import com.coffee.dto.IAccountEmployeeDto;
import com.coffee.model.employee.Employee;


public interface IEmployeeService {
    /**
     * @param {id}
     * @return employee
     * @creator ThongNV
     * Date 10/08/2022
     * this method employee find by id
     */
    Employee findById(Integer id);

    /**
     * @param
     * @return employee
     * @creator ThongNV
     * Date 10/08/2022
     * this method update employee, employee find by id
     */
    Employee editEmployee(Employee employee);
}
