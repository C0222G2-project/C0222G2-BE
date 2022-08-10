package com.coffee.service;

import com.coffee.model.bill.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBillService {
    Page<Bill> findAll(Pageable pageable);
    Bill findByBillCode(String billCode);
}
