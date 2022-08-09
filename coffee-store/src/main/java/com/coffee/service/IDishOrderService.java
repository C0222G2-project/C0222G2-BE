package com.coffee.service;

import com.coffee.model.dish_order.DishOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDishOrderService {
    Page<DishOrder> getAllOrder(Pageable pageable);

    DishOrder createOrder(DishOrder orderDish);

    List<DishOrder> getOrderHaveOrderCode(String tableId);
}
