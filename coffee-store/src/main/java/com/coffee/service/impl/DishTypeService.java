package com.coffee.service.impl;

import com.coffee.model.dish.DishType;
import com.coffee.repository.dish.IDishTypeRepository;
import com.coffee.service.IDishTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DishTypeService implements IDishTypeService {
    @Autowired
    private IDishTypeRepository iDishTypeRepository;

    @Override
    public Page<DishType> findAllDishType(Pageable pageable) {
        return null;
    }

    @Override
    public DishType findDishById(Integer id) {
        return null;
    }

    @Override
    public void deleteDish(Integer id) {

    }
}
