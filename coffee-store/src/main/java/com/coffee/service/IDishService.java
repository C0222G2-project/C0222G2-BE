package com.coffee.service;

import com.coffee.model.dish.Dish;

import java.util.Optional;

public interface IDishService {
    void save(Dish dish);

    Optional<Dish> findById(int id);

    Dish editDish(Dish dish);
}
