package com.coffee.controller;

<<<<<<< HEAD
import com.coffee.dto.employe.EmployeeDTOCreate;
import com.coffee.dto.employe.EmployeeDTOEdit;
import com.coffee.model.account.AppUser;
import com.coffee.model.employee.Employee;
import com.coffee.model.employee.Position;
import com.coffee.service.IAppUserService;
=======
import com.coffee.dto.employe.IEmployeeDTO;
>>>>>>> 6b95ecb89627f5df07aeb272d8eddaac17c96bdd
import com.coffee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import javax.validation.Valid;

import java.util.List;
=======
import java.util.Optional;
>>>>>>> 6b95ecb89627f5df07aeb272d8eddaac17c96bdd


@RestController
@CrossOrigin
@RequestMapping("/rest")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService iEmployeeService;

<<<<<<< HEAD

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param
     * @return  Position list
     */
    @GetMapping("/position")
    public ResponseEntity<List<Position>> getAllPosition() {
        List<Position> positionList = iPositionService.getAllPosition();
        return new ResponseEntity<>(positionList, HttpStatus.OK);
    }

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param
     * @return  AppUser list
     */
    @GetMapping("/user")
    public ResponseEntity<List<AppUser>> getAllUser() {
        List<AppUser> userList = iUserService.getAllUser();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    /**
     * @function ( find the employee of the id )
     * @creator TaiLV
     * @date-create 09/08/2022
     * @param id
     * @return true: id status 200 / false: status 404
     */
    @GetMapping("/employee/findId/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iEmployeeService.findById(id), HttpStatus.OK);
    }

    /**
     * @creator TaiLV
     * @function ( create the value of the employee )
     * Date 09/08/2022
     * @param employeeDTO
     * @param bindingResult
     * if employee null : Create new employee
     * @return  true: employee, status 200 / false: status 404
     */
    @PostMapping("/employee/create")
    public ResponseEntity<Void> saveEmployee(@Valid @RequestBody EmployeeDTOCreate employeeDTO , BindingResult bindingResult) {

        new EmployeeDTOCreate().validate(employeeDTO,bindingResult);

        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Employee employee =new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);


        iEmployeeService.saveEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * @creator TaiLV
     * @function ( edit the value of the employee )
     * Date 09/08/2022
     * @param employeeDTOEdit
     * @param bindingResult
     * if employee null : Create new employee
     * @return  true: employee, status 200 / false: status 404
     */
    @PatchMapping(value = "/employee/edit")
    public ResponseEntity<Void> editEmployee(@Valid @RequestBody EmployeeDTOEdit employeeDTOEdit , BindingResult bindingResult) {

        Employee employee = this.iEmployeeService.findById(employeeDTOEdit.getId());

        if(employee == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        new EmployeeDTOEdit().validate(employeeDTOEdit,bindingResult);
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        BeanUtils.copyProperties(employeeDTOEdit, employee);
        iEmployeeService.editEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


=======
    /**
     * Create by TuyenTN
     * Create date: 16:30
     * Method getAllEmployee show list and paging and search
     * @param pageable
     * @param searchName
     * @param searchPhone
     * @param searchAccount
     * @return
     */
    @GetMapping("/employee/list")
    public ResponseEntity<Page<IEmployeeDTO>> getAllEmployee(@PageableDefault(5) Pageable pageable,
                                                             Optional<String> searchName,
                                                             Optional<String> searchPhone,
                                                             Optional<String> searchAccount) {
        String searchByName = searchName.orElse("");
        String searchByPhone = searchPhone.orElse("");
        String searchByAccount = searchAccount.orElse("");
        if (searchByName.equals("null")) {
            searchByName = "";
        }
        if (searchByPhone.equals("null")) {
            searchByPhone = "";
        }
        if (searchByAccount.equals("null")) {
            searchByPhone = "";
        }
        Page<IEmployeeDTO> employeePage = this.iEmployeeService.getAllEmployee(pageable, searchByName, searchByPhone,searchByAccount);
        System.out.println(employeePage);
        if (employeePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeePage, HttpStatus.OK);
    }

    /**
     * Create by TuyenTN
     * Create data: 9-8-2022 23:14
     * findEmployeeById(id)
     * @param id
     * @return
     */
    @GetMapping("/employee/find/{id}")
    public ResponseEntity<IEmployeeDTO> findEmployeeById(@PathVariable Integer id){
        IEmployeeDTO iEmployeeDTO = this.iEmployeeService.findEmployeeById(id);
        if (iEmployeeDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iEmployeeDTO,HttpStatus.OK);
    }

    /**
     * Create by TuyenTN
     * Create data: 9-8-2022 23:14
     * deleteEmployeeById(id)
     * @param id
     * @return
     */

    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Integer id) {
        IEmployeeDTO iEmployeeDTO = this.iEmployeeService.findEmployeeById(id);
        if (iEmployeeDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.iEmployeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
>>>>>>> 6b95ecb89627f5df07aeb272d8eddaac17c96bdd
}
