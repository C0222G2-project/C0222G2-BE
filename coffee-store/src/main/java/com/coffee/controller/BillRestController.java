package com.coffee.controller;

import com.coffee.model.bill.Bill;
import com.coffee.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/rest")
@RestController
@CrossOrigin
public class BillRestController {

    @Autowired
    public IBillService iBillService;

    @GetMapping("/bill")
    public ResponseEntity<Page<Bill>> getAllBill(@PageableDefault(10) Pageable pageable,
                                                 @RequestParam Optional<String> searchParamCode,
                                                 @RequestParam Optional<String> searchParamDate){
        String searchCode = searchParamCode.orElse("");
        String searchDate = searchParamDate.orElse("");
        Page<Bill> bills = this.iBillService.getAll(pageable, searchCode, searchDate);
        if (bills.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


}
