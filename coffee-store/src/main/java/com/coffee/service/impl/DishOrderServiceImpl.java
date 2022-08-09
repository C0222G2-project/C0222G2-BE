package com.coffee.service.impl;

import com.coffee.model.dish_order.DishOrder;
import com.coffee.repository.IDishOrderRepository;
import com.coffee.service.IDishOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishOrderServiceImpl implements IDishOrderService {
    @Autowired
    private IDishOrderRepository dishOrderRepository;

    @Override
    public Page<DishOrder> getAllOrder(Pageable pageable) {
        return dishOrderRepository.getAllOrder(pageable);
    }

    @Override
    public DishOrder createOrder(DishOrder orderDish) {
        return dishOrderRepository.createOrder(orderDish.getCoffeeTable().getId(), orderDish.getCode(),
                orderDish.getQuantity(), orderDish.getDish().getId(), orderDish.getBill().getId(),
                orderDish.getEmployee().getId());
    }

    @Override
    public List<DishOrder> getOrderHaveOrderCode(String tableId) {
        return dishOrderRepository.getOrderHaveTableId(tableId);
    }
}
