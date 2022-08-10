package com.coffee.repository;

import com.coffee.model.dish_order.DishOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface IDishOrderRepository extends JpaRepository<DishOrder, Integer> {

    /**
     *   Author: BinhPX
     *   Date created: 09/08/2022
     *   This function will return all data can get below database use native query
     *   .@param pageable, @return
     **/
    @Query(value = "select coffee_table_id, `code`, quantity, dish_id, bill_id, " +
            "employee_id from dish_order where is_deleted = 0", nativeQuery = true)
    Page<DishOrder> getAllOrder(Pageable pageable);


    /**
     *   Author: BinhPX
     *   Date created: 09/08/2022
     *   This function create order menu and insert into database, use native query
     *   .@param is object, @return
     **/
    @Modifying
    @Query(value = "insert into dish_order(coffee_table_id, `code`, quantity, dish_id, bill_id, employee_id)" +
            "values (:table_id, :order_code, :quantity, :dish, :bill_id, :employee_id)", nativeQuery = true)
    void createOrder(@Param("table_id") int tableId, @Param("order_code") String orderCode,
                          @Param("quantity") Integer quantity, @Param("dish") Integer dish,
                          @Param("bill_id") Integer billId, @Param("employee_id") Integer employeeId);


    /**
     *   Author: BinhPX
     *   Date created: 09/08/2022
     *   This function find any order have table id match param.
     *   .@param table id, @return
     **/
    @Query(value = "select coffee_table_id, `code`, quantity, dish_id, bill_id, " +
            "employee_id from dish_order where is_deleted = 0 and coffee_table_id = :param", nativeQuery = true)
    List<DishOrder> getOrderHaveCode(@Param("param") String param);
}
