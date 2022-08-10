package com.coffee.service.impl;

import com.coffee.dto.IDishMostOrderDto;
import com.coffee.dto.IDishNewestDto;
import com.coffee.repository.IDishOrderRepository;
import com.coffee.service.IDishOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IDishOrderServiceImpl implements IDishOrderService {

    @Autowired
    private IDishOrderRepository iDishOrderRepository;

    @Override
    public List<IDishMostOrderDto> get5DishMostOrderDTO() {
        return iDishOrderRepository.get5DishMostOrderDTO();
    }

    @Override
    public List<IDishNewestDto> get5DishNewestDTO() {
        return iDishOrderRepository.get5DishNewestDTO();
    }
}
