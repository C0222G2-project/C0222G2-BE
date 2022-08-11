package com.coffee.controller;

import com.coffee.dto.DishDto;
import com.coffee.model.dish.Dish;
import com.coffee.service.IDishService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping(value = "/dish")
@CrossOrigin
@Controller
public class DishRestController {
    @Autowired
    private IDishService iDishService;

    /**
     * @function ( create new Dish)
     * @param dishDto
     * @return dish, status 201
     * @creator PhucLV
     * @date-create 09/08/2022
     */

    @PostMapping(value = "/create")
    public ResponseEntity<FieldError> createDish( @RequestBody @Valid DishDto dishDto,
                                                  BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.UPGRADE_REQUIRED);
        }
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDto, dish);
        iDishService.save(dish);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    /**
     * @function ( find the dish of the id )
     * @creator PhucLV
     * @date-create 09/08/2022
     * @param id
     * @return true: id status 200 / false: status 404
     */

    @GetMapping("/{id}")
    public ResponseEntity<Dish> findById(@PathVariable int id) {
        Optional<Dish> dishOptional = iDishService.findById(id);
        if (!dishOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dishOptional.get(), HttpStatus.OK);
    }

    /**
     * @function ( edit the value of the dish )
     * @param id
//     * @param dishDto
     * @return true: dish, status 200 / false: status 404
     * @creator PhucLV
     * @date-create 09/08/2022
     */

    @PatchMapping("/edit/{id}")
    public ResponseEntity<FieldError> updateDish( @PathVariable int id, @RequestBody @Valid DishDto dishDto ,BindingResult bindingResult) {
        Optional<Dish> dishOptional = iDishService.findById(id);
        if (!dishOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.UPGRADE_REQUIRED);
        }
        dishDto.setId(dishOptional.get().getId());
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDto, dish);

        iDishService.editDish(dish);
        return new ResponseEntity<>( HttpStatus.OK);
    }

}
