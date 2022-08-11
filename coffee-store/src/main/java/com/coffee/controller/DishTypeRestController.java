package com.coffee.controller;

import com.coffee.model.dish.DishType;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/dishType")
public class DishTypeRestController {

    @Autowired
    private IDishTypeService iDishTypeService;

    /**
     * Created by: HieuCD
     * Date created: 09/08/2022
     * function: get type of dish Page
     * @param pageable
     * @return
     *    HTTP status  200(OK) : return Page<DishType> dishTypePage
     *    HTTP status  204(NO_CONTENT): return dishTypePage is empty
     */
    @GetMapping("/getDishTypePage")
    public ResponseEntity<Page<DishType>> getAllDishType(@PageableDefault(10) Pageable pageable) {
        Page<DishType> dishTypePage = this.iDishTypeService.findAllDishType(pageable);
        if (dishTypePage.isEmpty()) {
            return new ResponseEntity<>(dishTypePage, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dishTypePage, HttpStatus.OK);
        }
    }

    /**
     * Created by: HieuCD
     * Date created: 10/08/2022
     * function: get type of dish Page
     * @param id
     * @return
     *      * HTTP status  204(NO_CONTENT) : id = null
     *      * HTTP status  200(OK) : return a dishType
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity<DishType> findById(@PathVariable Integer id) {
        DishType dishType = this.iDishTypeService.findDishTypeById(id);
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dishType, HttpStatus.OK);
    }
}
