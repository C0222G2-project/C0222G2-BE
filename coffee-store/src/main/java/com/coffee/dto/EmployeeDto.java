package com.coffee.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.sql.Date;


@Getter
@Setter
@RequiredArgsConstructor
public class EmployeeDto {
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
}
