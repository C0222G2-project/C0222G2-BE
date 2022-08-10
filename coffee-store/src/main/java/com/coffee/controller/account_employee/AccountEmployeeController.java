package com.coffee.controller.account_employee;

import com.coffee.dto.AppUserDto;
import com.coffee.dto.EmployeeDto;
import com.coffee.dto.IEmployeeDto;
import com.coffee.model.account.AppUser;
import com.coffee.model.employee.Employee;
import com.coffee.model.employee.Position;
import com.coffee.service.app_user.IAppUserService;
import com.coffee.service.employee.IEmployeeService;
import com.coffee.service.position.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/account/accountEmployee")
public class AccountEmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IPositionService iPositionService;

    @Autowired
    private IAppUserService iAppUserService;


    /**
     * @param
     * @return Position list
     * @creator ThongNV
     * Date 09/08/2022
     */
    @GetMapping("/position")
    public ResponseEntity<List<Position>> getAllPosition() {
        List<Position> positionList = iPositionService.getAllPosition();
        return new ResponseEntity<>(positionList, HttpStatus.OK);
    }

    /**
     * @param
     * @return employee
     * @creator ThongNV
     * Date 10/08/2022
     */
    @GetMapping("/{id}")
    public ResponseEntity<IEmployeeDto> infoAccountEmployeeById(@PathVariable("id") Integer id) {
        IEmployeeDto employeeDTO = iEmployeeService.findById(id);
        if (employeeDTO == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }
    /**
     * @param
     * @return new employee edited
     * @creator ThongNV
     * Date 10/08/2022
     */
    @PatchMapping("/update/{id}")
    public ResponseEntity<List<FieldError>> updateAccountEmployee(@PathVariable Integer id, @Validated @RequestBody EmployeeDto employeeDto,
                                                                  BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        Employee employee = new Employee();
        employee.setId(id);
        BeanUtils.copyProperties(employeeDto, employee);
        this.iEmployeeService.updateAccountEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PatchMapping("/updateAccount")
    public ResponseEntity<Object> updateAccount(
            @PathVariable Integer id,
            @RequestBody AppUserDto appUserDto,
            BindingResult bindingResult) {
        AppUserDto appUserDto1 = iAppUserService.findById(id);
        if (appUserDto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        new AppUserDto().validate(appUserDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        AppUser appUser = new AppUser();
        BeanUtils.copyProperties(appUserDto, appUser);
        this.iAppUserService.update(appUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @Autowired
//    private IEmployeeRepository iEmployeeRepository;
//    @GetMapping("/test")
//        public ResponseEntity<EmployeeDTO> test(){
//            EmployeeDTO employeeDTO = iEmployeeRepository.test(6);
//            return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
//        }
}
