package com.coffee.service.impl;


import com.coffee.dto.employe.IEmployeeDTO;
import com.coffee.model.employee.Employee;
import com.coffee.repository.IEmployeeRepository;
import com.coffee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    /**
<<<<<<< HEAD
     * Create by TuyenTN
     * Date: 9-8-2022 16:37
     * @param pageable
     * @param searchByName
     * @param searchByPhone
     * @param searchByAccount
     * @return
     */
    @Override
    public Page<IEmployeeDTO> getAllEmployee(Pageable pageable, String searchByName, String searchByPhone, String searchByAccount) {
        return iEmployeeRepository.getAllEmployee(pageable,"%"+searchByName+"%","%"+searchByPhone+"%",
                "%"+searchByAccount+"%");
    }

    /**
     * Create by TuyenTN
     * Date: 9-8-2022
     * findEmployeeById(id)
     * @param id
     * @return
     */
    @Override
    public IEmployeeDTO findEmployeeById(Integer id) {
        return this.iEmployeeRepository.findEmployeeById(id);
    }

    /**
     * Create by TuyenTN
     * Date: 9-8-2022
     * deleteEmployeeById()
     * @param id
     */
    @Override
    public void deleteEmployeeById(Integer id) {
        this.iEmployeeRepository.deleteEmployeeById(id);
    }

    /**
=======
>>>>>>> a132af98fc8efbb150d5e181ad09360cb50a0d78
     * @creator TaiLV
     * Date 09/08/2022
     * @param employee
     * if employee null : Create new employee
     * @return  create Employee success
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
     * @return  update Employee success
     */
    @Override
    public Employee editEmployee(Employee employee) {
        return iEmployeeRepository.editEmployee(employee.getName(), employee.getImage(),employee.getBirthday(),employee.getEmail(),
                employee.getGender(),employee.getPhoneNumber(),employee.getAddress(),employee.getSalary(),employee.getPosition());
    }


}
