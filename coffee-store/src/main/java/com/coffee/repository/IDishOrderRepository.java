package com.coffee.repository;

import com.coffee.model.dish_order.DishOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDishOrderRepository extends JpaRepository<DishOrder, Integer> {

    //Method Get List Most Order By BaoTQ
    @Query(value = " SELECT dish_id FROM (SELECT dish_order.dish_id, sum(quantity) as time_order FROM dish_order " +
            " GROUP BY  dish_order.dish_id ORDER BY time_order DESC LIMIT 5) as test_table;",nativeQuery = true)
    List<DishOrder> get5DishMostOrder();

}
