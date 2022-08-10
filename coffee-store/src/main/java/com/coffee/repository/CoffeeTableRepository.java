package com.coffee.repository;


import com.coffee.model.coffee_table.CoffeeTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CoffeeTableRepository extends JpaRepository<CoffeeTable, Integer> {
    @Query(value="select * from coffee_table where is_deleted = 0", nativeQuery = true)
    Page<CoffeeTable> findAll(Pageable pageable);

    @Query(value="select * from coffee_table where is_deleted = 0 and id = :codeTable", nativeQuery = true)
    CoffeeTable findByCode(@Param("codeTable") String codeTable);

}
