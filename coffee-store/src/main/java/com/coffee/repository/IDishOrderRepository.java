package com.coffee.repository;

import com.coffee.model.dish_order.DishOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IDishOrderRepository extends JpaRepository<DishOrder, Integer> {

/**
 *Create By HoaNN
 * Date create 08/08/2022
 * function displayListDishOrderInTable
 *
 *
 */
    @Query(value=" select dish.name, dish.price, dishOrder.quantity,table.code " +
            " from dishOrder " +
            " join dish on dish.id = dishOrder.dish_id  ")
    List<DishOrder> displayListDishOrderByIdInTable();

}
