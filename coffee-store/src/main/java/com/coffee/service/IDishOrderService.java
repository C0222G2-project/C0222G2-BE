package com.coffee.service;

import com.coffee.model.dish_order.DishOrder;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IDishOrderService {
    /**
     *Create By HoaNN
     * Date create 08/08/2022
     * function displayListDishOrderInTable
     *
     *
     */
    List<DishOrder> displayListDishOrderInTable();
}

