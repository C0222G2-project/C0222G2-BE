package com.coffee.service.impl;


import com.coffee.model.employee.Employee;
import com.coffee.reponsitory.IEmployeeRepository;
import com.coffee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param employee
     * if employee null : Create new employee
     * @return  true: create employee success, status 200 / false: status 404
     */
    @Override
    public Employee saveEmployee(Employee employee) {
        return iEmployeeRepository.saveEmployee(employee);
    }

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param id
     * if id null : Bad request
     * @return  object Employee
     */
    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepository.findByIdEmployee(id);
    }

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param employee
     * if employee null : Create new employee
     * @return  true: edit employee success, status 200 / false: status 404
     */
    @Override
    public Employee editEmployee(Employee employee) {
        return iEmployeeRepository.editEmployee(employee.getName(), employee.getImage(),employee.getBirthday(),employee.getEmail(),
                employee.getGender(),employee.getPhoneNumber(),employee.getAddress(),employee.getSalary(),employee.getPosition());
    }


}
