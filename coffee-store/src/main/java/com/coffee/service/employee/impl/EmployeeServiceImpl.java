package com.coffee.service.employee.impl;

import com.coffee.dto.IAccountEmployeeDto;
import com.coffee.model.employee.Employee;
import com.coffee.repository.employee.IEmployeeRepository;
import com.coffee.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;



    /**
     * @param {id}
     * @return employee
     * @creator ThongNV
     * Date 10/08/2022
     * this method employee find by id
     */
    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepository.findByIdEmployee();
    }

    /**
     * @param
     * @return employee
     * @creator ThongNV
     * Date 10/08/2022
     * this method update employee, employee find by id
     */
    @Override
    public Employee editEmployee(Employee employee) {
        return iEmployeeRepository.editEmployee(employee.getName(), employee.getImage(),employee.getBirthday(),employee.getEmail(),
                employee.getGender(),employee.getPhoneNumber(),employee.getAddress(),employee.getSalary(),employee.getPosition());
    }
}
