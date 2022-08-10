package com.coffee.service;



import com.coffee.dto.employe.IEmployeeDTO;
import com.coffee.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    /**
     * Create by TuyenTN
     * Data: 9-8-2022
     * @param pageable
     * @param searchByName
     * @param searchByPhone
     * @param searchByAccount
     * @return
     */
    Page<IEmployeeDTO> getAllEmployee(Pageable pageable, String searchByName, String searchByPhone, String searchByAccount);

    /**
     * Create: TuyenTN
     * Data:9-8-2022
     * @param id
     * @return
     */
    IEmployeeDTO findEmployeeById(Integer id);

    /**
     * Create:TuyenTN
     * Data:9-8-2022
     * @param id
     */
    void deleteEmployeeById(Integer id);


    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param employee
     * if employee null : Create new employee
     * @return  create Employee success
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
     * if employee null : Create new employee
     * @return  update Employee success
     */
    Employee editEmployee(Employee employee);



}
