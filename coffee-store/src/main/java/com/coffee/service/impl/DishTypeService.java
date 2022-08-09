package com.coffee.service.impl;

import com.coffee.repository.IDishTypeRepository;
import com.coffee.service.IDishTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishTypeService implements IDishTypeService {
    @Autowired
    private IDishTypeRepository iDishTypeRepository;

}
