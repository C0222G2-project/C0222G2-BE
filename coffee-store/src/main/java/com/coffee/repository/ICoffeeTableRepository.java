package com.coffee.repository;

import com.coffee.dto.ICoffeeTableDto;
import com.coffee.dto.ITotalPaymentDto;
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

    /**
     * Create HoaNN
     * Date create 10/08/2022
     *
     * @param id
     * @return
     */
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

    /**
     * Create HoaNN
     * Date create 10/08/2022
     *
     * @param pageable
     * @return
     */
    @Query(value = " select code " +
            " from coffee_table ",
            countQuery = " select count(*) from " +
                    "( select code from coffee_table ) temp ",
            nativeQuery = true)
    Page<ICoffeeTableDto> displayCoffeeTableByPage(Pageable pageable);

    /**
     * Create HoaNN
     * Date create 10/08/2022
     *+
     * @param id
     * @return
     */
    @Query(value = " select dto_table.name,dto_table.price,dto_table.quantity,dto_table.code, dto_table.total_bill " +
            " as total " +
            " from (select dish.name , dish.price , dish_order.quantity , coffee_table.code," +
            " sum(ifnull((dish.price * dish_order.quantity),0)) as total_bill " +
            " from dish_order " +
            " join dish on dish.id = dish_order.dish_id " +
            " join coffee_table on dish_order.coffee_table_id = coffee_table.id " +
            " where coffee_table.id = :idKey2) as dto_table",
            nativeQuery = true )
    ITotalPaymentDto totalPayment(@Param("idKey2") Integer id);
}
