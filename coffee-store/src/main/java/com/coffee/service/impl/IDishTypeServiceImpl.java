package com.coffee.service.impl;

import com.coffee.model.dish.Dish;
import com.coffee.model.dish.DishType;
import com.coffee.repository.IDishTypeRepository;
import com.coffee.service.IDishTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IDishTypeServiceImpl implements IDishTypeService {
    @Autowired
    private IDishTypeRepository iDishTypeRepository;
    @Override
    public List<DishType> findAll() {
        return iDishTypeRepository.findAll();
    }
}
