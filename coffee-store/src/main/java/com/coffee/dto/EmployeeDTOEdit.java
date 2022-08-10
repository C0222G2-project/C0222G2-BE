package com.coffee.dto;


import com.coffee.model.account.AppUser;
import com.coffee.model.employee.Position;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class EmployeeDTOEdit implements Validator {
    private Integer id;

    @NotBlank(message = "vui lòng điền thông tin")
    private String name;

    @NotBlank(message = "vui lòng điền thông tin")
    private String image;

    @NotBlank(message = "vui lòng điền thông tin")
    private String phoneNumber;

    @NotBlank(message = "vui lòng điền thông tin")
    private String address;

    @NotBlank(message = "vui lòng điền thông tin")
    @Email(message = "vui lòng nhập đúng định dạng email")
    private String email;

    private int gender;
    private String birthday;

    @PositiveOrZero(message = "vui lòng nhập lương lớn hơn 0 ")
    private Double salary;

    private Integer isDeleted;

    private Position position;



    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDTO employeeDTO = (EmployeeDTO) target;

        if (employeeDTO.getSalary() % 100000 != 0) {
            errors.rejectValue("salary", "create.salary", "vui lòng nhập lương là bội của 100.000");
        }
    }

    public EmployeeDTOEdit() {
    }

    public EmployeeDTOEdit(Integer id, String name, String image, String phoneNumber, String address, String email,
                       int gender, String birthday, Double salary, Integer isDeleted, Position position) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        this.salary = salary;
        this.isDeleted = isDeleted;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
