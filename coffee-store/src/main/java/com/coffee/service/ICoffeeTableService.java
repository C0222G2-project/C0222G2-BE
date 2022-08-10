package com.coffee.service;

import com.coffee.dto.ICoffeeTableDto;
import com.coffee.model.coffee_table.CoffeeTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICoffeeTableService {

    /**
     * Create HoaNN
     * Date Create 08/08/2020
     * @param id
     * @return
     */
    List<ICoffeeTableDto> findByIdTable(Integer id);

    Page<CoffeeTable> displayCoffeeTableByPage(Pageable pageable);
}
