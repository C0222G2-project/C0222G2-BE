package com.coffee.repository;

import com.coffee.model.bill.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBillRepository extends JpaRepository<Bill, Integer> {


    @Query(value = "select bill.id, bill.code, bill.creation_date, bill.is_deleted, employee.name, coffee_table.code, "+
            " dish_order.quantity, dish.name, dish.price " +
            " from bill " +
            " left join dish_order on bill.id = dish_order.bill_id " +
            " left join employee on dish_order.employee_id = employee.id " +
            " left join coffee_table on dish_order.coffee_table_id = coffee_table.id " +
            " left join dish on dish_order.dish_id = dish.id " +
            " where code like :searchCode and creation_date like :ssearchDate and is_deleted = 0", nativeQuery = true,
            countQuery ="select (id,code,creation_date,is_deleted) from " +
                    " (select id,code,creation_date,is_deleted from bill " +
                    " where code like :searchCode and creation_date like :ssearchDate and is_deleted = 0) temp_table")
    Page<Bill> getAllBill(Pageable pageable, @Param("searchCode") String searchCode,
                          @Param("searchDate") String searchDate);



    @Query(value = "select bill.id, bill.code, bill.creation_date, bill.is_deleted, employee.name, coffee_table.code, "+
            " dish_order.quantity, dish.name, dish.price " +
            " from bill" +
            " left join dish_order on bill.id = dish_order.bill_id " +
            " left join employee on dish_order.employee_id = employee.id " +
            " left join coffee_table on dish_order.coffee_table_id = coffee_table.id " +
            " left join dish on dish_order.dish_id = dish.id " +
            " where id = idDetail and is_deleted = 0", nativeQuery = true)
    Bill getByIdBill(@Param("idDetail") Integer id);
}
