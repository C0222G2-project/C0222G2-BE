package com.coffee.dto;

import com.coffee.model.account.AppUser;
import com.coffee.model.employee.Employee;
import com.coffee.model.employee.Position;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
public class EmployeeDto implements Validator {
    private Integer id;

    private String name;

    private Date birthday;

    private Integer gender;

    private String phoneNumber;

    private String address;

    private String email;

    private Double salary;

    private String image;

    private Boolean isDeleted;

    private Position position;

    private AppUser appUser;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EmployeeDto emloyeeDto = (EmployeeDto) o;
        return id != null && Objects.equals(id, emloyeeDto.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
