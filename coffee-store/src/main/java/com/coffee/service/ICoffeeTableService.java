package com.coffee.service;

import com.coffee.model.coffee_table.CoffeeTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICoffeeTableService {
    Page<CoffeeTable> findAll(Pageable pageable);

    CoffeeTable findByCode(String code);
}
