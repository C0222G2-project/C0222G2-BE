package com.coffee.service.impl;


import com.coffee.model.coffee_table.CoffeeTable;
import com.coffee.repository.CoffeeTableRepository;
import com.coffee.service.ICoffeeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CoffeeTableServiceImpl implements ICoffeeTableService {
    @Autowired
    private CoffeeTableRepository coffeeTableRepository;
    @Override
    public Page<CoffeeTable> findAll(Pageable pageable) {
        return coffeeTableRepository.findAll(pageable);
    }

    @Override
    public CoffeeTable findByCode(String code) {
        return coffeeTableRepository.findByCode('%' + code + '%');
    }
}
