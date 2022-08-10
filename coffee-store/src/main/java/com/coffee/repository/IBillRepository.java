package com.coffee.repository;

import com.coffee.model.bill.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepository extends JpaRepository<Bill, Integer> {
    @Query(value = "select * from bill where is_deleted = 0", nativeQuery = true)
    Page<Bill> findAll(Pageable pageable);

    @Query(value = "select * from bill where is_deleted =0 and code like :billCode", nativeQuery = true)
    Bill findByBillCode(@Param("billCode") String billCode);
}
