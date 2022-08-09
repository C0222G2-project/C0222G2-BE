package com.coffee.controller;

import com.coffee.dto.employe.IEmployeeDTO;
import com.coffee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService iEmployeeService;

    /**
     * Create by TuyenTN
     * Create date: 16:30
     * Method getAllEmployee show list and paging and search
     * @param pageable
     * @param searName
     * @param searchPhone
     * @param searchAccount
     * @return
     */

    @GetMapping("/list")
    public ResponseEntity<Page<IEmployeeDTO>> getAllEmployee(@PageableDefault(5) Pageable pageable,
                                                             Optional<String> searName,
                                                             Optional<String> searchPhone,
                                                             Optional<String> searchAccount) {
        String searchByName = searName.orElse("");
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
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
    @GetMapping("/find/{id}")
    public ResponseEntity<IEmployeeDTO> findEmployeeById(@PathVariable Integer id){
        IEmployeeDTO iEmployeeDTO = this.iEmployeeService.findEmployeeById(id);
        if (iEmployeeDTO == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Integer id){
        this.iEmployeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
