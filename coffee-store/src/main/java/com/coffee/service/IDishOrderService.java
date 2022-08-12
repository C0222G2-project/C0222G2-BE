package com.coffee.service;

import com.coffee.dto.DishMostOrderDTO;
import com.coffee.dto.DishNewestDTO;

import java.util.List;

public interface IDishOrderService {

    /**
     * Created by: BaoTQ
     * Date create: 09/08/2022
     * function: get 5 dish most order
     */
    List<DishMostOrderDTO> get5DishMostOrderDTO();


    /**
     * Created by: BaoTQ
     * Date create: 09/08/2022
     * function: get 5 dish newest
     */
    List<DishNewestDTO> get5DishNewestDTO();
}
