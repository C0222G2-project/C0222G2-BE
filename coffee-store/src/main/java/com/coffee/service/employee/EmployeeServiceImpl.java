package com.coffee.service.employee;

import com.coffee.repository.employee.IEmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private IEmployeeRepository iEmployeeRepository;
}
