package com.coffee.service;

import com.coffee.model.dish.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDishService {
    Page<Dish> findAllDish(Pageable pageable);
    Dish findDishById(Integer id);
    void deleteDish(Integer id);
}
