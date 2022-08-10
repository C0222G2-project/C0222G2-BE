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
     * @return
     */

    @Query(value =" select dish.name, dish.price, dish_order.quantity,coffee_table.code " +
            " from dish_order " +
            " join dish on dish.id = dish_order.dish_id " +
            " join coffee_table on dish_order.coffee_table_id = coffee_table.id", nativeQuery= true)
    List<DishOrder> displayListDishOrderByIdInTable();

}
