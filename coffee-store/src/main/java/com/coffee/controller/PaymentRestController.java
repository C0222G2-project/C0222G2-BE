package com.coffee.controller;


import com.coffee.dto.ICoffeeTableDto;
import com.coffee.model.coffee_table.CoffeeTable;
import com.coffee.service.ICoffeeTableService;
import com.coffee.service.IDishOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/payment")
public class PaymentRestController {

    @Autowired
    private IDishOrderService iDishOrderService;

    @Autowired
    private ICoffeeTableService iCoffeeTableService;

    /**
     * Create: HoaNN
     * Date create: 09/08/2022
     * function display list order by id coffee table
     *
     * @param id
     * @return
     */
    @GetMapping("list/{id}")
    public ResponseEntity<List<ICoffeeTableDto>> displayDishOrderByIdTable(@PathVariable("id") Integer id) {
        List<ICoffeeTableDto> iCoffeeTableDtoList = this.iCoffeeTableService.findByIdTable(id);
        if (iCoffeeTableDtoList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iCoffeeTableDtoList, HttpStatus.OK);
    }

//    /**
//     * Create: HoaNN
//     * Date create: 09/08/2022
//     * function display list tables coffee by page
//     * (em fix lỗi xong page )
//     * @param pageable
//     * @return
//     */
//    @GetMapping("/page")
//    public ResponseEntity<Optional<CoffeeTable>> getCoffeeTablePage(@PageableDefault(size = 6) Pageable pageable) {
//        Optional<CoffeeTable> coffeeTablePage = this.iCoffeeTableService.displayCoffeeTableByPage(pageable);
//
//    }
}
