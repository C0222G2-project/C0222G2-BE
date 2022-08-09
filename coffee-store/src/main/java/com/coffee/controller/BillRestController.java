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

    /**
     * Created by: HauLT
     * Date created: 09/08/2022
     * function: Show bill list, with pagination,search by bill number and creation date
     *
     * @param pageable
     * @param searchParamCode
     * @param searchParamDate
     * @return Page<Bill>
     */

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

    /**
     * Created by: HauLT
     * Date created: 09/08/2022
     * function: show bill details by id
     *
     * @param id
     * @return object Bill
     */
    @GetMapping("/bill/{id}")
    public ResponseEntity<Bill> getById(@PathVariable Integer id){
        Bill bill = this.iBillService.findById(id);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }


}
