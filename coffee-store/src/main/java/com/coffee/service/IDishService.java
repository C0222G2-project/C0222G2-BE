package com.coffee.service;

import com.coffee.model.dish.Dish;

import java.util.Optional;

public interface IDishService {
    Dish save(Dish dish);

    Optional<Dish> findById(int id);

    Dish editDish(Dish dish);
}
