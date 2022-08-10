package com.coffee.dto;

import com.coffee.model.dish_order.DishOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class CoffeTableDto {
    private Integer id;

    private String code;

    private Boolean isEmpty;

    private Boolean status;

    private Boolean isDeleted;

    private List<DishOrder> dishOrders;
}
