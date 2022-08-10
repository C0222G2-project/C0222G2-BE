package com.coffee.repository;

import com.coffee.model.coffee_table.CoffeeTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICoffeeTableRepository extends JpaRepository<CoffeeTable, Integer> {
}
