package com.coffee.service.impl;

import com.coffee.dto.ICoffeeTableDTO;
import com.coffee.model.coffee_table.CoffeeTable;
import com.coffee.repository.ICoffeeTableRepository;
import com.coffee.service.ICoffeeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeTableService implements ICoffeeTableService {

    @Autowired
    private ICoffeeTableRepository iCoffeeTableRepository;

    /**
     * Create By HoaNN
     * Date create 08/08/2022
     */
    @Override
    public List<ICoffeeTableDTO> findByIdTable(Integer id) {
        return this.iCoffeeTableRepository.displayTableById(id);
    }

    @Override
    public Optional<CoffeeTable> displayCoffeeTableByPage(Pageable pageable) {
        return null;
    }


}
