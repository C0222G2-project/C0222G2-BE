package com.coffee.service;

import com.coffee.dto.ICoffeeTableDTO;
import com.coffee.model.coffee_table.CoffeeTable;
import org.springframework.data.domain.Pageable;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;
import java.util.Optional;

public interface ICoffeeTableService {

    /**
     * Create HoaNN
     * Date Create 08/08/2020
     * @param id
     * @return
     */
    List<ICoffeeTableDTO> findByIdTable(Integer id);

    Optional<CoffeeTable> displayCoffeeTableByPage(Pageable pageable);
}
