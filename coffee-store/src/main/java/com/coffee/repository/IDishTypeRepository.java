package com.coffee.repository;

import com.coffee.model.dish.DishType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDishTypeRepository extends JpaRepository<DishType, Integer> {
}
