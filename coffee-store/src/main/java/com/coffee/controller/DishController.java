package com.coffee.controller;

import com.coffee.model.dish.Dish;
import com.coffee.service.IDishService;
import com.coffee.service.IDishTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping(value = "/dish")
@CrossOrigin
@Controller
public class DishController {
    @Autowired
    private IDishService iDishService;
    @Autowired
    private IDishTypeService iDishTypeService;
    @PostMapping(value = "/create")
    public ResponseEntity<Dish> createDish(@RequestBody Dish dish) {

        return new ResponseEntity<>(iDishService.save(dish), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Dish> findById(@PathVariable int id) {
        Optional<Dish> dishOptional = iDishService.findById(id);
        if (!dishOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dishOptional.get(), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Dish> updateDish(@PathVariable int id, @RequestBody Dish dish) {
        Optional<Dish> dishOptional = iDishService.findById(id);
        if (!dishOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dish.setId(dishOptional.get().getId());
        return new ResponseEntity<>(iDishService.editDish(dish), HttpStatus.OK);
    }


}
