package com.coffee.controller;

import com.coffee.dto.IDishMostOrderDto;
import com.coffee.dto.IDishNewestDto;
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



    /**
     * Created by: BaoTQ
     * Date create: 09/08/2022
     * function: display 5 dish most order
     */
    @GetMapping("/most-order")
    public ResponseEntity<List<IDishMostOrderDto>> getListDishMostOrder(){
        List<IDishMostOrderDto> mostOrderList = iDishOrderService.get5DishMostOrderDTO();
        if(mostOrderList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mostOrderList, HttpStatus.OK);
    }


    /**
     * Created by: BaoTQ
     * Date create: 09/08/2022
     * function: display 5 dish newest
     */
    @GetMapping("/newest")
    public ResponseEntity<List<IDishNewestDto>> getListDishNewest(){
        List<IDishNewestDto> newestList = iDishOrderService.get5DishNewestDTO();
        if(newestList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(newestList, HttpStatus.OK);
    }


}
