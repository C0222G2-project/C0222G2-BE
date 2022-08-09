package com.coffee.repository;

import com.coffee.model.dish.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDishRepository extends JpaRepository<Dish, Integer> {


}
