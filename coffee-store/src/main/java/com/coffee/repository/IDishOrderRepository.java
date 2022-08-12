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
public interface IDishOrderRepository extends JpaRepository<DishOrder, Integer> {

    /**
     *   Author: BinhPX
     *   Date created: 09/08/2022
     *   This function will return all data can get below database use native query
     *   .@param pageable, @return
     **/
    @Query(value = "select id, coffee_table_id, `code`, quantity, dish_id, bill_id, " +
            "employee_id, is_deleted from dish_order where is_deleted = 0", nativeQuery = true)
    Page<DishOrder> getAllOrder(Pageable pageable);


    /**
     *   Author: BinhPX
     *   Date created: 09/08/2022
     *   This function create order menu and insert into database, use native query
     *   .@param is object, @return
     **/
    @Transactional
    @Modifying
    @Query(value = "insert into dish_order(coffee_table_id, code, quantity, dish_id, bill_id, employee_id)" +
            "values (:#{#dishOrder.coffeeTable.id}, :#{#dishOrder.code}, :#{#dishOrder.quantity}, " +
            ":#{#dishOrder.dish.id}, :#{#dishOrder.bill.id}, :#{#dishOrder.employee.id})", nativeQuery = true)
    void createOrder(DishOrder dishOrder);


    /**
     *   Author: BinhPX
     *   Date created: 09/08/2022
     *   This function find any order have table id match param.
     *   .@param table id, @return
     **/
    @Query(value = "select coffee_table_id, `code`, quantity, dish_id, bill_id, " +
            "employee_id from dish_order where is_deleted = 0 and coffee_table_id = :param", nativeQuery = true)
    List<DishOrder> getOrderHaveCode(@Param("param") String param);


    /**
     *   Author: BinhPX
     *   Date created: 12/08/2022
     *   This function delete order have code order match param.
     *   .@param table id, @return
     **/
    @Transactional
    @Modifying
    @Query(value = "update dish_order set is_deleted = 1 where code = :code", nativeQuery = true)
    void deleteOrder(@Param("code") String code);
}
