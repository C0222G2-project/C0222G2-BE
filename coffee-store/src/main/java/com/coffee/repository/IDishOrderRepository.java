package com.coffee.repository;

import com.coffee.dto.IDishMostOrderDto;
import com.coffee.dto.IDishNewestDto;
import com.coffee.model.dish_order.DishOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDishOrderRepository extends JpaRepository<DishOrder, Integer> {
    /**
     * Created by: BaoTQ
     * Date create: 09/08/2022
     * function: get 5 dish most order in database
     */
    @Query(value = " SELECT dishId, name, price, image, time_order as timeOrder " +
            " FROM (SELECT dish_order.dish_id as dishId, dish.name as name, dish.price as price," +
            " dish.image as image, sum(quantity) as time_order " +
            " FROM dish_order inner join dish on dish_order.dish_id = dish.id " +
            " GROUP BY  dish_order.dish_id ORDER BY time_order DESC LIMIT 5) as dto_table"
            , nativeQuery = true)
    List<IDishMostOrderDto> get5DishMostOrderDTO();


    /**
     * Created by: BaoTQ
     * Date create: 09/08/2022
     * function: get 5 dish newest in database
     */
    @Query(value = " SELECT id,name,creation_date as dateCreate,price,image " +
            " FROM dish ORDER BY creation_date DESC LIMIT 5", nativeQuery = true)
    List<IDishNewestDto> get5DishNewestDTO();

}
