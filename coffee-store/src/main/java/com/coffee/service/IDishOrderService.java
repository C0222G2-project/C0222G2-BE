package com.coffee.service;

import com.coffee.dto.DishMostOrderDTO;
import com.coffee.dto.DishNewestDTO;

import java.util.List;

public interface IDishOrderService {

    /**
     * BaoTQ
     * get 5 dish most order
     */
    List<DishMostOrderDTO> get5DishMostOrderDTO();


    /**
     * BaoTQ
     * get 5 dish newest
     */
    List<DishNewestDTO> get5DishNewestDTO();
}
