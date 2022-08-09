package com.coffee.service.impl;

import com.coffee.model.dish.Dish;
import com.coffee.repository.IDishRepository;
import com.coffee.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DishService implements IDishService {
    @Autowired
    private IDishRepository iDishRepository;

    @Override
    public Dish save(Dish dish) {
        return iDishRepository.saveDish(dish);
    }

    @Override
    public Optional<Dish> findById(int id) {
        return iDishRepository.findByIdDish(id);
    }

    @Override
    public Dish editDish(Dish dish) {
        return iDishRepository.editDish(dish);
    }
}
