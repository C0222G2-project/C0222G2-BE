package com.coffee.service.impl;

import com.coffee.model.dish_order.DishOrder;
import com.coffee.repository.IDishOrderRepository;
import com.coffee.service.IDishOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishOrderServiceImpl implements IDishOrderService {
@Autowired
private IDishOrderRepository iDishOrderRepository;
    /**
     *Create By HoaNN
     * Date create 08/08/2022
     *
     */
    @Override
    public List<DishOrder> displayListDishOrderInTable() {
        return this.iDishOrderRepository.displayListDishOrderByIdInTable();
    }


}
