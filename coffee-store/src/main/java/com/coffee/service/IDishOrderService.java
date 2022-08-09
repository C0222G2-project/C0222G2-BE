package com.coffee.service;

import com.coffee.model.dish_order.DishOrder;

import java.util.List;

public interface IDishOrderService {
    List<DishOrder> get5DishMostOrder();
}
