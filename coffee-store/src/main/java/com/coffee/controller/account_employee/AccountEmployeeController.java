package com.coffee.controller.account_employee;

import com.coffee.dto.AppUserDto;
import com.coffee.dto.AccountEmployeeDto;
import com.coffee.dto.EmployeeDto;
import com.coffee.dto.IAccountEmployeeDto;
import com.coffee.model.account.AppUser;
import com.coffee.model.employee.Employee;
import com.coffee.model.employee.Position;
import com.coffee.service.account_employee.IAccountEmployeeService;
import com.coffee.service.app_user.IAppUserService;
import com.coffee.service.employee.IEmployeeService;
import com.coffee.service.position.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/account")
public class AccountEmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IPositionService iPositionService;

    @Autowired
    private IAppUserService iAppUserService;

    @Autowired
    private IAccountEmployeeService iAccountEmployeeService;


//    /**
//     * @param
//     * @return Position list
//     * @creator ThongNV
//     * Date 09/08/2022
//     * this method get all position
//     */
//    @GetMapping("/position")
//    public ResponseEntity<List<Position>> getAllPosition() {
//        List<Position> positionList = iPositionService.getAllPosition();
//        return new ResponseEntity<>(positionList, HttpStatus.OK);
//    }

    /**
     * @param {id}
     * @return accountEmployeeDto
     * @creator ThongNV
     * Date 10/08/2022
     * this method accountEmployeeDto find by id
     */
    @GetMapping("/accountEmployee/{id}")
    public ResponseEntity<IAccountEmployeeDto> findById(@PathVariable("id") Integer id) {
        IAccountEmployeeDto accountEmployeeDto = iAccountEmployeeService.findAccountById(id);
        if (accountEmployeeDto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accountEmployeeDto, HttpStatus.OK);
    }

    /**
     * @param {id}
     * @return employee
     * @creator ThongNV
     * Date 10/08/2022
     * this method employee find by id
     */
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> findByID(@PathVariable Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iEmployeeService.findById(id), HttpStatus.OK);
    }

    /**
     * @param
     * @return new employee edited
     * @creator ThongNV
     * Date 10/08/2022
     */
    @PatchMapping("/updateAccountEmployee/{id}")
    public ResponseEntity<Employee> editeEmployee(@RequestBody EmployeeDto employeeDto, BindingResult bindingResult, @PathVariable Integer id) {

        Employee employee = this.iEmployeeService.findById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        BeanUtils.copyProperties(employeeDto, employee);
        return new ResponseEntity<>(iEmployeeService.editEmployee(employee), HttpStatus.CREATED);
    }
    /**
     * @param
     * @return new password accountEmployee
     * @creator ThongNV
     * Date 10/08/2022
     * Chức năng này liên quan đến security của anh Phương, đợi gọp code lên nhánh dev rồi em pull dự án về triển khai tiếp
     */
//    @PatchMapping("/editPassword")
//    public ResponseEntity<Object> updatePasswordAccount(
//            @RequestParam Integer id,
//            @RequestBody AccountEmployeeDto accountEmployeeDto,
//            BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        IAccountEmployeeDto iAccountEmployeeDto = iAccountEmployeeService.findAccountById(id);
//        if (iAccountEmployeeDto != null) {
//            iAccountEmployeeService.updatePassword(passwordEncoder.encode(accountEmployeeDto.getPassword()), accountEmployeeDto.getPosition().getId(), id);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//    @Autowired
//    PasswordEncoder passwordEncoder;
}

