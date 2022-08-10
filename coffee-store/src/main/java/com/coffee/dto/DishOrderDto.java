package com.coffee.dto;

import com.coffee.model.bill.Bill;
import com.coffee.model.coffee_table.CoffeeTable;
import com.coffee.model.dish.Dish;
import com.coffee.model.employee.Employee;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;


@Getter
@Setter
@RequiredArgsConstructor
public class DishOrderDto {

    @NotNull
    @Min(value = 0, message = "Must greater than 1")
    private Integer quantity;

    @NotNull
    private CoffeTableDto coffeeTable;

    @NotNull
    private BillDto bill;


    @NotNull
    private EmployeeDto employee;


    @NotNull
    private DishDto dish;
}
