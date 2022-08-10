package com.coffee.service.account_employee.impl;

import com.coffee.dto.IAccountEmployeeDto;
import com.coffee.repository.account_employee.IAccountRepository;
import com.coffee.service.account_employee.IAccountEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountEmployeeService implements IAccountEmployeeService {
    @Autowired
    private IAccountRepository iAccountRepository;

    /**
     * @param {id}
     * @return accountEmployeeDto
     * @creator ThongNV
     * Date 10/08/2022
     * this method find accountEmployeeDto by id
     */
    @Override
    public IAccountEmployeeDto findAccountById(Integer id) {
        return iAccountRepository.findByAccountId(id);
    }
}
