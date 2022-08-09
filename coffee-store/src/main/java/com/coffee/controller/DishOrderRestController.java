package com.coffee.controller;

import com.coffee.model.dish_order.DishOrder;
import com.coffee.service.IDishOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dish-order")
public class DishOrderRestController {
    @Autowired
    private IDishOrderService iDishOrderService;

    @GetMapping("/most-order")
    public ResponseEntity<List<DishOrder>> getMostOrder(){
        List<DishOrder> mostOrderList = iDishOrderService.get5DishMostOrder();
        return new ResponseEntity<>(mostOrderList, HttpStatus.OK);
    }
}
