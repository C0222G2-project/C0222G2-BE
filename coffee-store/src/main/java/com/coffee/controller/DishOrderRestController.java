package com.coffee.controller;

import com.coffee.dto.DishMostOrderDTO;
import com.coffee.dto.DishNewestDTO;
import com.coffee.repository.IDishOrderRepository;
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

    @Autowired
    private IDishOrderRepository iDishOrderRepository;


    /**
     * BaoTQ
     * display 5 dish most order
     */
    @GetMapping("/most-order")
    public ResponseEntity<List<DishMostOrderDTO>> getMostOrder(){
        List<DishMostOrderDTO> mostOrderList = iDishOrderService.get5DishMostOrderDTO();
        return new ResponseEntity<>(mostOrderList, HttpStatus.OK);
    }


    /**
     * BaoTQ
     * display 5 dish newest
     */
    @GetMapping("/newest")
    public ResponseEntity<List<DishNewestDTO>> getNewest(){
        List<DishNewestDTO> newestList = iDishOrderRepository.get5DishNewestDTO();
        return new ResponseEntity<>(newestList, HttpStatus.OK);
    }


}
