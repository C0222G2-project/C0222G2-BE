package com.coffee.controller;

import com.coffee.model.dish.Dish;
import com.coffee.model.dish.DishType;
import com.coffee.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/dish")
public class DishRestController {

    @Autowired
    private IDishService iDishService;

    /**
     * Created by: HieuCD
     * Date created: 09/08/2022
     * function: show dish page
     *
     * @param pageable
     * @return HTTP status  200(OK) : return Page<Dish> dishPage
     * HTTP status  204(NO_CONTENT): return dishPage is empty
     */
    @GetMapping("/getDishPage")
    public ResponseEntity<Page<Dish>> getAllDish(@PageableDefault(4) Pageable pageable) {
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
     * function: search dish
     *
     * @param pageable
     * @param dishName
     * @param dishCode
     * @param dishPrice
     * @param dishTypeId
     * @return * HTTP status  200(OK) : return Page<Dish> dishPage
     * * HTTP status  204(NO_CONTENT): return dishPage is empty
     */
    @GetMapping("/searchDish")
    public ResponseEntity<Page<Dish>> getAllDish(@PageableDefault(10) Pageable pageable,
                                                 Optional<String> dishName,
                                                 Optional<String> dishCode,
                                                 Optional<String> dishPrice,
                                                 Optional<String> dishTypeId) {
        String name = dishName.orElse("");
        String code = dishCode.orElse("");
        String price = dishPrice.orElse("");
        String typeId = dishTypeId.orElse("");
        if (typeId.equals("")) {
            typeId = "%" + typeId + "%";
        }

        if (name.equals("null")) {
            name = "";
        }
        if (code.equals("null")) {
            code = "";
        }
        if (price.equals("null")) {
            price = "";
        }

        Page<Dish> dishPage = this.iDishService.searchDish(name, code, price, typeId, pageable);
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
     *
     * @param id
     * @return HTTP status  204(NO_CONTENT) : id = null
     * HTTP status  200(OK) : return a dish
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity<Dish> findById(@PathVariable Integer id) {
        Dish dish = this.iDishService.findDishById(id);
        if (dish == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }

    /**
     * Created by: HieuCD
     * Date created: 09/08/2022
     * function: delete dish by dish
     *
     * @param id
     * @return HTTP status  204(NO_CONTENT) : id = null
     * HTTP status  200(OK) : deleted
     */
    @PatchMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable Integer id) {
        this.iDishService.deleteDish(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
