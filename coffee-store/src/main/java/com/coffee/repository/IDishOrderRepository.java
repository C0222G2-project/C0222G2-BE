package com.coffee.repository;


import com.coffee.dto.IDishMostOrderDto;
import com.coffee.dto.IDishNewestDto;
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
     * Author: BinhPX
     * Date created: 09/08/2022
     * This function will return all data can get below database use native query
     * .@param pageable, @return
     **/
    @Query(value = "select id, coffee_table_id, `code`, quantity, dish_id, bill_id, " +
            "employee_id, is_deleted from dish_order where is_deleted = 0",countQuery = "select count(*) from" +
            " ( select id, coffee_table_id, `code`, quantity, dish_id, bill_id, employee_id, is_deleted " +
            "from dish_order where is_deleted = 0 ) as dishOrder",
            nativeQuery = true)
    Page<DishOrder> getAllOrder(Pageable pageable);


    /**
     * Author: BinhPX
     * Date created: 09/08/2022
     * This function create order menu and insert into database, use native query
     * .@param is object, @return
     **/
    @Transactional
    @Modifying
    @Query(value = "insert into dish_order(coffee_table_id, `code`, quantity, dish_id, bill_id, employee_id)" +
            "values (:table_id, :order_code, :quantity, :dish, :bill_id, :employee_id)", nativeQuery = true)
    void createOrder(@Param("table_id") int tableId, @Param("order_code") String orderCode,
                     @Param("quantity") Integer quantity, @Param("dish") Integer dish,
                     @Param("bill_id") Integer billId, @Param("employee_id") Integer employeeId);
    @Query(value = "insert into dish_order(coffee_table_id, code, quantity, dish_id, bill_id, employee_id)" +
            "values (:#{#dishOrder.coffeeTable.id}, :#{#dishOrder.code}, :#{#dishOrder.quantity}, " +
            ":#{#dishOrder.dish.id}, :#{#dishOrder.bill.id}, :#{#dishOrder.employee.id})", nativeQuery = true)
    void createOrder(DishOrder dishOrder);


    /**
     * Author: BinhPX
     * Date created: 09/08/2022
     * This function find any order have table id match param.
     * .@param table id, @return
     **/
    @Query(value = "select id, coffee_table_id, `code`, quantity, dish_id, bill_id, " +
            "employee_id, is_deleted from dish_order where is_deleted = 0 and coffee_table_id = :param", nativeQuery = true)
    List<DishOrder> getOrderHaveCode(@Param("param") String param);


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
