package com.coffee.repository;

import com.coffee.model.bill.Bill;
import com.coffee.model.dish_order.DishOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IDishOrderRepository extends JpaRepository<DishOrder, Integer> {
    /**
     * @param billAfter
     * @param idTable
     * @author HoaNN
     */
    @Transactional
    @Modifying
    @Query(value = " UPDATE `dish_order` SET `bill_id` = :#{#billAfter.id} WHERE (`coffee_table_id` = :idTable) ", nativeQuery = true)
    void updateBill(Bill billAfter, @Param("idTable") int idTable);
}
