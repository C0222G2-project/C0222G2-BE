package com.coffee.repository;

import com.coffee.model.dish_order.DishOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DishOrderRepository extends JpaRepository<DishOrder, Integer> {

//    display list dishorder
//    author: HoaNN
//    @Query(value=" select dish.name, dish.price, dishOrder.quantity,table ")
//    List<DishOrder> displayListDishOrderByIdTable();

}
