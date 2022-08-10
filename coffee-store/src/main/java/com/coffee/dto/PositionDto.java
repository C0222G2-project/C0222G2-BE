package com.coffee.dto;

import com.coffee.model.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class PositionDto {
    private Integer id;

    private String name;
    private List<Employee> employees;
}
