package com.coffee.repository;

import com.coffee.dto.ICoffeeTableDto;
import com.coffee.model.coffee_table.CoffeeTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICoffeeTableRepository extends JpaRepository<CoffeeTable, Integer> {


    @Query(value = "select dto_table.name,dto_table.price,dto_table.quantity,dto_table.code, dto_table.tong_tien " +
            " as payment " +
            " from (select dish.name , dish.price , dish_order.quantity , coffee_table.code," +
            " ifnull((dish.price * dish_order.quantity),0) as tong_tien " +
            " from dish_order " +
            " join dish on dish.id = dish_order.dish_id " +
            " join coffee_table on dish_order.coffee_table_id = coffee_table.id " +
            " where coffee_table.id = :idKey) as dto_table",
            nativeQuery = true)
    List<ICoffeeTableDto> displayTableById(@Param("idKey") Integer id);

//    @Query(value = "select coffee_table.code from coffee_table", nativeQuery = true)
//    Page<CoffeeTable> displayCoffeeTableByPage(Pageable pageable);

}
