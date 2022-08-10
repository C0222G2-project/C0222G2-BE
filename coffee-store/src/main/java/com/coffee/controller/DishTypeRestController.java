package com.coffee.controller;

import com.coffee.model.dish.Dish;
import com.coffee.model.dish.DishType;
import com.coffee.service.IDishService;
import com.coffee.service.IDishTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/dishType")
public class DishTypeRestController {

    @Autowired
    private IDishTypeService iDishTypeService;

    @GetMapping("/dishTypePage")
    public ResponseEntity<Page<DishType>> getAllDishType(@PageableDefault(10) Pageable pageable) {
        Page<DishType> dishTypePage = this.iDishTypeService.findAllDishType(pageable);
        if (dishTypePage.isEmpty()) {
            return new ResponseEntity<>(dishTypePage, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dishTypePage, HttpStatus.OK);
        }
    }
}
