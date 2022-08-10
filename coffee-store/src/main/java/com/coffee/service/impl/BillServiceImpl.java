package com.coffee.service.impl;

import com.coffee.model.bill.Bill;
import com.coffee.repository.IBillRepository;
import com.coffee.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements IBillService {
    @Autowired
    private IBillRepository iBillRepository;

    @Override
    public Page<Bill> findAll(Pageable pageable) {
        return iBillRepository.findAll(pageable);
    }

    @Override
    public Bill findByBillCode(String billCode) {
        return iBillRepository.findByBillCode('%'+billCode+'%');
    }
}
