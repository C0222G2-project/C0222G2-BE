package com.coffee.service;


import com.coffee.model.employee.Employee;

public interface IEmployeeService {
    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param employee
     * @return  true: create employee success, status 200 / false: status 404
     */
    Employee saveEmployee(Employee employee);

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param id
     * if id null : Bad request
     * @return  object Employee
     */
    Employee findById(Integer id);

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param employee
     * @return  true: edit employee success, status 200 / false: status 404
     */
    Employee editEmployee(Employee employee);


}
