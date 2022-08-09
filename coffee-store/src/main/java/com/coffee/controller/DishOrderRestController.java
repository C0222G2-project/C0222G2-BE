package com.coffee.controller;

import com.coffee.model.dish.Dish;
import com.coffee.model.dish_order.DishOrder;
import com.coffee.service.IDishOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dish-order")
public class DishOrderRestController {
    @Autowired
    private IDishService iDishService;
    @Autowired
    private IDishTypeService iDishTypeService;
    @Autowired
    private IDishOrderService iDishOrderService;

    @GetMapping("/dish")
    public ResponseEntity<Page<Dish>> getAllDish(@PageableDefault(4)Pageable pageable,
                                                 @RequestParam("page") Optional<Integer> page,
                                                 @RequestParam("size") Optional<Integer> size){
        Page<Dish> dishes = iDishService.findAll();
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }

    @GetMapping("/dish-type")
    public ResponseEntity<List<Dish>> getAllDishType(){
        List<Dish> dishesType = iDishTypeService.findAll();
        return new ResponseEntity<>(dishesTypes, HttpStatus.OK);
    }

    @PostMapping("/dish-order")
    public ResponseEntity<DishOrder> createOrder(@RequestBody DishOrder dishOrder){
        iDishOrderService.createOrder(dishOrder);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
