package com.coffee.controller;

import com.coffee.dto.EmployeeDTO;
import com.coffee.dto.employe.IEmployeeDTO;
import com.coffee.model.account.AppUser;
import com.coffee.model.employee.Employee;
import com.coffee.model.employee.Position;
import com.coffee.service.IAppUserService;
import com.coffee.service.IEmployeeService;
import com.coffee.service.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IAppUserService iUserService;

    /**
<<<<<<< HEAD
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

}
