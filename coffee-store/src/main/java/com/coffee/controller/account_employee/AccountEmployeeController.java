package com.coffee.controller.account_employee;

import com.coffee.dto.account_employee.IAccountEmployeeDto;
import com.coffee.model.employee.Employee;
import com.coffee.service.app_user.IAppUserService;
import com.coffee.service.employee.IEmployeeService;
import com.coffee.service.position.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
