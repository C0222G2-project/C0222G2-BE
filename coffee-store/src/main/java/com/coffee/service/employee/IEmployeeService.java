package com.coffee.service.employee;

import com.coffee.dto.IEmployeeDto;
import com.coffee.model.employee.Employee;


public interface IEmployeeService {

    /**
     * @param
     * @return employee
     * @creator ThongNV
     * Date 10/08/2022
     */
    IEmployeeDto findById(Integer id);

    void updateAccountEmployee(Employee employee);
}
