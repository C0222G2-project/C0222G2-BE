package com.coffee.dto;

import com.coffee.model.dish.DishType;
import com.coffee.model.dish_order.DishOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class DishDto {
    private Integer id;

    private String code;

    private String name;

    private Double price;

    private String image;

    private String creationDate;

    private Boolean isDeleted;

    private DishTypeDto dishTypeDto;

    private List<DishOrder> dishOrders;
}
