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
    @Query(value = "select coffee_table_id, code, quantity, dish_id, bill_id, " +
            "employee_id from dish_order where is_delete = 0", nativeQuery = true)
    Page<DishOrder> getAllOrder(Pageable pageable);

    @Modifying
    @Query(value = "insert into order_dish(coffee_table_id, code, quantity, dish_id, bill_id, employee_id)" +
            "values (:table_id, :order_code, :quantity, :dish, :bill_id, :employee_id)", nativeQuery = true)
    DishOrder createOrder(@Param("table_id") Integer tableId, @Param("order_code") String orderCode,
                          @Param("quantity") Integer quantity, @Param("dish") Integer dish,
                          @Param("bill_id") Integer billId, @Param("employee_id") Integer employeeId);

    @Query(value = "select coffee_table_id, code, quantity, dish_id, bill_id, " +
            "employee_id from dish_order where is_delete = 0 and coffee_table_id = :tableId", nativeQuery = true)
    List<DishOrder> getOrderHaveTableId(@Param("tableId") String tableId);
}
