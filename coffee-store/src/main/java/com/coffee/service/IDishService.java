package com.coffee.service;

import com.coffee.model.dish.Dish;
import com.coffee.model.dish.DishType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDishService {
    Page<Dish> findAllDish(Pageable pageable);
    Dish findDishById(Integer id);
    void deleteDish(Integer id);
    Page<Dish> searchDish(String name, String code, String price, String dishTypeId,Pageable pageable);
}
