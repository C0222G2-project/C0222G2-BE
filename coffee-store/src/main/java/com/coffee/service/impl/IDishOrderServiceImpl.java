package com.coffee.service.impl;

import com.coffee.model.dish_order.DishOrder;
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
    public List<DishOrder> get5DishMostOrder() {
        return iDishOrderRepository.get5DishMostOrder();
    }
}
