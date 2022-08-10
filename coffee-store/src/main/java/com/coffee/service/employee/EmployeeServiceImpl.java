package com.coffee.service.employee;

import com.coffee.dto.IEmployeeDto;
import com.coffee.model.employee.Employee;
import com.coffee.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    /**
     * @param
     * @return employee
     * @creator ThongNV
     * Date 10/08/2022
     */
    @Override
    public IEmployeeDto findById(Integer id) {
        return this.iEmployeeRepository.findByEmployeeId(id).orElse(null);
    }
    /**
     * @param
     * @return new employee edited
     * @creator ThongNV
     * Date 10/08/2022
     */
    @Override
    public void updateAccountEmployee(Employee employee) {
        this.iEmployeeRepository.updateAccount(employee);
    }

//    @Override
//    public Employee findById(Integer id) {
//        return this.iEmployeeRepository.findByEmployeeId(id).orElse(null);
//    }
}
