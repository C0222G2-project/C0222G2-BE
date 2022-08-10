package com.coffee.service;

import com.coffee.dto.IDishMostOrderDto;
import com.coffee.dto.IDishNewestDto;

import java.util.List;

public interface IDishOrderService {

    /**
     * Created by: BaoTQ
     * Date create: 09/08/2022
     * function: get 5 dish most order
     */
    List<IDishMostOrderDto> get5DishMostOrderDTO();


    /**
     * Created by: BaoTQ
     * Date create: 09/08/2022
     * function: get 5 dish newest
     */
    List<IDishNewestDto> get5DishNewestDTO();
}
