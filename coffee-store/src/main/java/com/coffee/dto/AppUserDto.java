package com.coffee.dto;

import com.coffee.model.account.UserRole;
import com.coffee.model.employee.Employee;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.util.List;

public class AppUserDto implements Validator {
    private Integer id;
    private String userName;
    private String password;
    private Date creationDate;
    private Boolean isDeleted;
    private List<UserRole> userRoles;
    private Employee employee;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
