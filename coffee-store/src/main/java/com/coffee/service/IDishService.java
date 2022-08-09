package com.coffee.service;

import com.coffee.model.dish.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDishService {
    Page<Dish> findAll(Pageable pageable);
    Dish findById(Integer id);
    void delete(Integer id);
}
