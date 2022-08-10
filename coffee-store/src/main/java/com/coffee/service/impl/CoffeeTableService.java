package com.coffee.service.impl;

import com.coffee.dto.ICoffeeTableDto;
import com.coffee.dto.ITotalPaymentDto;
import com.coffee.model.coffee_table.CoffeeTable;
import com.coffee.repository.ICoffeeTableRepository;
import com.coffee.service.ICoffeeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeTableService implements ICoffeeTableService {

    @Autowired
    private ICoffeeTableRepository iCoffeeTableRepository;

    @Override
    public List<ICoffeeTableDto> findByIdTable(Integer id) {
        return this.iCoffeeTableRepository.displayTableById(id);
    }

    @Override
    public Page<ICoffeeTableDto> displayCoffeeTableByPage(Pageable pageable) {
        return this.iCoffeeTableRepository.displayCoffeeTableByPage(pageable);
    }

    @Override
    public ITotalPaymentDto calcultion(Integer id) {
        return this.iCoffeeTableRepository.totalPayment(id);
    }

}
