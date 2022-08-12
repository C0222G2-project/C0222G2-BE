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


    /**
     *   Author: BinhPX
     *   Date created: 09/08/2022
     *   This function will return all data can get, @param pageable, @return
     **/
    @Override
    public Page<DishOrder> getAllOrder(Pageable pageable) {
        return dishOrderRepository.getAllOrder(pageable);
    }

    /**
     *   Author: BinhPX
     *   Date created: 09/08/2022
     *   This function create new order menu, @param orderDish, @return
     **/
    @Override
    public void createOrder(DishOrder orderDish) {
        dishOrderRepository.createOrder(orderDish);
//        createOrder(orderDish.getCoffeeTable().getId(), orderDish.getCode(),
//                orderDish.getQuantity(), orderDish.getDish().getId(), orderDish.getBill().getId(),
//                orderDish.getEmployee().getId());
    }


    /**
     *   Author: BinhPX
     *   Date created: 09/08/2022
     *   This function return order menu could find, @param tableId, @return list DishOrder
     **/
    @Override
    public List<DishOrder> getOrderHaveCode(String param) {
        return dishOrderRepository.getOrderHaveCode(param);
    }

    @Override
    public void deleteDishOrder(String param) {
        dishOrderRepository.deleteOrder(param);
    }
}
