package com.coffee.controller;


import com.coffee.dto.ICoffeeTableDto;
import com.coffee.dto.ITotalPaymentDto;
import com.coffee.service.ICoffeeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/payment")
public class PaymentRestController {

    @Autowired
    private ICoffeeTableService iCoffeeTableService;

    /**
     * Create: HoaNN
     * Date create: 09/08/2022
     * function display list order by id coffee table
     *
     * @param id
     */
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_STAFF')")
    @GetMapping("/list/{id}")
    public ResponseEntity<List<ICoffeeTableDto>> displayDishOrderByIdTable(@PathVariable("id") Integer id) {
        List<ICoffeeTableDto> iCoffeeTableDtoList = this.iCoffeeTableService.findByIdTable(id);
        if (iCoffeeTableDtoList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iCoffeeTableDtoList, HttpStatus.OK);
    }

    /**
     * Create: HoaNN
     * Date create: 09/08/2022
     * function display list tables coffee by page
     *
     * @param pageable
     */
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_STAFF')")
    @GetMapping("/page")
    public ResponseEntity<Page<ICoffeeTableDto>> getCoffeeTablePage(@PageableDefault(size = 6) Pageable pageable) {
        Page<ICoffeeTableDto> iCoffeeTableDtoPage = this.iCoffeeTableService.displayCoffeeTableByPage(pageable);
        if (iCoffeeTableDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (iCoffeeTableDtoPage.getTotalPages() != pageable.getPageNumber()) {

            return new ResponseEntity<>(iCoffeeTableDtoPage, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Create: HoaNN
     * Date create: 09/08/2022
     * function used to payment
     *
     * @param id
     */
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_STAFF')")
    @GetMapping("/total/{id}")
    public ResponseEntity<ITotalPaymentDto> calculation(@PathVariable("id") Integer id) {
        ITotalPaymentDto iTotalPaymentDto = this.iCoffeeTableService.calcultion(id);
        if (iTotalPaymentDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iTotalPaymentDto, HttpStatus.OK);
    }

    
}
