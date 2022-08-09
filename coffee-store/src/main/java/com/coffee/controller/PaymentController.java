package com.coffee.controller;


import com.coffee.model.dish_order.DishOrder;
import com.coffee.service.IDishOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    /**
     *Create By HoaNN
     * Date create 08/08/2022
     * function displayListDishOrderInTable
     *
     *
     */
    @Autowired
    private IDishOrderService iDishOrderService;

    @GetMapping("/list")
    public ResponseEntity<List<DishOrder>> displayOrder() {
        List<DishOrder> dishOrderList = this.iDishOrderService.displayListDishOrderInTable();
        return new ResponseEntity<>(dishOrderList, HttpStatus.OK);
    }


}
