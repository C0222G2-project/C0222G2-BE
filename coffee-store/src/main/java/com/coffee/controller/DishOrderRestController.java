package com.coffee.controller;

import com.coffee.dto.DishOrderDto;
import com.coffee.model.bill.Bill;
import com.coffee.model.coffee_table.CoffeeTable;
import com.coffee.model.dish.Dish;
import com.coffee.model.dish.DishType;
import com.coffee.model.dish_order.DishOrder;
import com.coffee.model.employee.Employee;
import com.coffee.service.IDishOrderService;
import com.coffee.service.IDishService;
import com.coffee.service.IDishTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/dish-order")
public class DishOrderRestController {
    @Autowired
    private IDishService iDishService;
    @Autowired
    private IDishTypeService iDishTypeService;
    @Autowired
    private IDishOrderService iDishOrderService;


    /**
     *   Author: BinhPX
     *   Date created: 09/08/2022
     *   This function will return data can get, @param pageable, @return
     **/
    @GetMapping("/dish")
    public ResponseEntity<Page<Dish>> getAllDish(@PageableDefault(4)Pageable pageable,
                                                 @RequestParam("page") Optional<Integer> page,
                                                 @RequestParam("size") Optional<Integer> size){
        Page<Dish> dishes = iDishService.findAll(pageable);
        if(dishes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }

    /**
     *   Author: BinhPX
     *   Date created: 09/08/2022
     *   This function will return all data can get, @return
     **/
    @GetMapping("/dish-type")
    public ResponseEntity<List<DishType>> getAllDishType(){
        List<DishType> dishesType = iDishTypeService.findAll();
        if(dishesType.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(dishesType, HttpStatus.OK);
    }


    /**
     *   Author: BinhPX
     *   Date created: 09/08/2022
     *   This function create new order, @param dishOrderDto, @return
     **/
    @PostMapping("/create-dishOrder")
    public ResponseEntity<List<FieldError>> createOrder(@Valid @RequestBody DishOrderDto dishOrderDto, BindingResult bindingResult){
        DishOrder dishOrder = new DishOrder();
        int numberCode = (int) (Math.random() * 9999);
        dishOrder.setCode("OD-" + numberCode);
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BeanUtils.copyProperties(dishOrderDto, dishOrder);
        Bill bill = new Bill();
        bill.setId(dishOrderDto.getBill().getId());
        dishOrder.setBill(bill);
        Employee employee = new Employee();
        employee.setId(dishOrderDto.getEmployee().getId());
        dishOrder.setEmployee(employee);
        Dish dish = new Dish();
        dish.setId(dishOrderDto.getDish().getId());
        dishOrder.setDish(dish);
        CoffeeTable coffeeTable = new CoffeeTable();
        coffeeTable.setId(dishOrderDto.getCoffeeTable().getId());
        dishOrder.setCoffeeTable(coffeeTable);
        iDishOrderService.createOrder(dishOrder);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     *   Author: BinhPX
     *   Date created: 10/08/2022
     *   This function get list, @param is pageable and page, size, @return status ok if size greater than 0
     *   and return status bad gateway if size equal 0
     **/
    @GetMapping("/get-dish-list")
    public ResponseEntity<Page<DishOrder>> getListOrder(@PageableDefault(4)Pageable pageable,
                                                        @RequestParam("page") Optional<Integer> page,
                                                        @RequestParam("size") Optional<Integer> size){
        Page<DishOrder> dishOrders = iDishOrderService.getAllOrder(pageable);
        if(dishOrders.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dishOrders, HttpStatus.OK);
    }

    /**
     *   Author: BinhPX
     *   Date created: 10/08/2022
     *   This function get order have code is, @param is a code, @return status ok if size greater than 0
     *   and return status bad gateway if size equal 0
     **/
    @GetMapping("/get-order-have-code/{code}")
    public ResponseEntity<List<DishOrder>> getOrderHaveCode(@PathVariable Optional<Integer> code){
        if(code.isPresent()){
            List<DishOrder> dishOrders = iDishOrderService.getOrderHaveCode(code.get());
            if(dishOrders.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                return new ResponseEntity<>(dishOrders, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

}
