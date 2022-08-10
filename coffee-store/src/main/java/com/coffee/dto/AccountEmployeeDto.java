package com.coffee.dto;

import com.coffee.model.account.AppUser;
import com.coffee.model.employee.Position;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
public class AccountEmployeeDto implements Validator {
    private Integer employeeId;

    private String employeeName;

    private Date employeeBirthday;

    private Integer employeeGender;

    private String employeePhoneNumber;

    private String employeeAddress;

    private String employeeEmail;

    private Double employeeSalary;

    private String employeeImage;

    private Position position;

    private AppUser appUser;

    @NotNull
    @Size(min = 6)
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AccountEmployeeDto accountEmployeeDto = (AccountEmployeeDto) o;
        return employeeId != null && Objects.equals(employeeId, accountEmployeeDto.employeeId);
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
