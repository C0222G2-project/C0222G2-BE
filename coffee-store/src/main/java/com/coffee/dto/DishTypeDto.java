package com.coffee.dto;

import com.coffee.model.dish.Dish;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class DishTypeDto {
    private Integer id;

    private String code;

    private String name;

    private Boolean isDeleted;

    private List<Dish> dishes;
}
