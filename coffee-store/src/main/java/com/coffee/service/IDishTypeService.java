package com.coffee.service;

import com.coffee.model.dish.DishType;

import java.util.List;

public interface IDishTypeService {
    List<DishType> findAll();
}
