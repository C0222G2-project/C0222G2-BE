package com.coffee.dto.account_employee;

import com.coffee.model.employee.Position;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountEmployeeDto {
    Integer employeeId;

    String employeeName;

    @NotNull
    Position position;

    String userName;

    @NotNull
    @Size(min = 3)
    String password;

    String employeeAddress;

    String employeeImage;

    String employeePhone;

    String employeeSalary;

    String employeeBirthDay;

    public AccountEmployeeDto() {
    }

    public AccountEmployeeDto(Integer employeeId, String employeeName, @NotNull Position position, String userName, @NotNull @Size(min = 3) String password, String employeeAddress, String employeeImage, String employeePhone, String employeeSalary, String employeeBirthDay) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.position = position;
        this.userName = userName;
        this.password = password;
        this.employeeAddress = employeeAddress;
        this.employeeImage = employeeImage;
        this.employeePhone = employeePhone;
        this.employeeSalary = employeeSalary;
        this.employeeBirthDay = employeeBirthDay;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeImage() {
        return employeeImage;
    }

    public void setEmployeeImage(String employeeImage) {
        this.employeeImage = employeeImage;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeBirthDay() {
        return employeeBirthDay;
    }

    public void setEmployeeBirthDay(String employeeBirthDay) {
        this.employeeBirthDay = employeeBirthDay;
    }
}
