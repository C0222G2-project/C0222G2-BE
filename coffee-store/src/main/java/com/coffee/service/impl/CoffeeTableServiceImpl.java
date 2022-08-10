package com.coffee.service.impl;


import com.coffee.dto.ICoffeeTableDto;
import com.coffee.dto.ITotalPaymentDto;
import com.coffee.model.coffee_table.CoffeeTable;
import com.coffee.repository.CoffeeTableRepository;
import com.coffee.service.ICoffeeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeTableServiceImpl implements ICoffeeTableService {
    @Autowired
    private CoffeeTableRepository coffeeTableRepository;

    @Override
    public List<ICoffeeTableDto> findByIdTable(Integer id) {
        return null;
    }

    @Override
    public Page<ICoffeeTableDto> displayCoffeeTableByPage(Pageable pageable) {
        return null;
    }

    @Override
    public ITotalPaymentDto calcultion(Integer id) {
        return null;
    }

    @Override
    public Page<CoffeeTable> findAll(Pageable pageable) {
        return coffeeTableRepository.findAll(pageable);
    }

    @Override
    public CoffeeTable findByCode(String code) {
        return coffeeTableRepository.findByCode('%' + code + '%');
    }
}
