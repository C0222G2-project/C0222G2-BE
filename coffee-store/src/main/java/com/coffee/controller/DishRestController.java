package com.coffee.controller;

import com.coffee.model.dish.Dish;
import com.coffee.service.IDishService;
import com.coffee.service.IDishTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/dish")
public class DishRestController {

    @Autowired
    private IDishService iDishService;
    @Autowired
    private IDishTypeService iDishTypeService;

    /**
     *
     * Created by: HieuCD
     * Date created: 09/08/2022
     * function: show dish page
     * @param pageable
     * @return
     */
    @GetMapping("")
    public ResponseEntity<Page<Dish>> getAllDish(@PageableDefault(10)Pageable pageable) {
        Page<Dish> dishPage = this.iDishService.findAllDish(pageable);
        if (dishPage.isEmpty()) {
            return new ResponseEntity<>(dishPage, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dishPage, HttpStatus.OK);
        }
    }

    /**
     * Created by: HieuCD
     * Date created: 09/08/2022
     * function: get dish by dish
     * @param id
     * @return
     */
    @GetMapping("/findById{id}")
    public ResponseEntity<Dish> findById(@PathVariable Integer id) {
        Dish dish = this.iDishService.findDishById(id);
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }

    /**
     * Created by: HieuCD
     * Date created: 09/08/2022
     * function: delete dish by dish
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable Integer id) {
        this.iDishService.deleteDish(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
