package com.coffee.service.impl;

import com.coffee.model.dish.Dish;
import com.coffee.repository.dish.IDishRepository;
import com.coffee.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DishService implements IDishService {
    @Autowired
    private IDishRepository iDishRepository;

    @Override
    public Page<Dish> findAll(Pageable pageable) {
        return iDishRepository.selectAllDishPage(pageable);
    }

    @Override
    public Dish findById(Integer id) {
        return iDishRepository.selectDishById(id);
    }

    @Override
    public void delete(Integer id) {
        iDishRepository.deleteDishById(id);
    }
}
