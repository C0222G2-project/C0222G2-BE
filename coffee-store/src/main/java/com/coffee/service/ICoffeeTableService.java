package com.coffee.service;

import com.coffee.dto.ICoffeeTableDto;
import com.coffee.dto.ITotalPaymentDto;
import com.coffee.model.coffee_table.CoffeeTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICoffeeTableService {


    List<ICoffeeTableDto> findByIdTable(Integer id);

    Page<ICoffeeTableDto> displayCoffeeTableByPage(Pageable pageable);


    ITotalPaymentDto calcultion(Integer id);

}
