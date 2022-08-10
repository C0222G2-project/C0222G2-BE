package com.coffee.service.account_employee;

import com.coffee.dto.IAccountEmployeeDto;

public interface IAccountEmployeeService {

    /**
     * @param {id}
     * @return accountEmployeeDto
     * @creator ThongNV
     * Date 10/08/2022
     * this method find accountEmployeeDto by id
     */
    IAccountEmployeeDto findAccountById(Integer id);

}
