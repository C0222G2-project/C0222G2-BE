package com.coffee.service;



<<<<<<< HEAD
import com.coffee.model.employee.Employee;
=======
import com.coffee.dto.employe.IEmployeeDTO;
>>>>>>> 6b95ecb89627f5df07aeb272d8eddaac17c96bdd
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {

<<<<<<< HEAD
    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param employee
     * if employee null : Create new employee
     * @return  create Employee success
     */
    void saveEmployee(Employee employee);

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
    void editEmployee(Employee employee);
=======

>>>>>>> 6b95ecb89627f5df07aeb272d8eddaac17c96bdd

}
