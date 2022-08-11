package com.coffee.service.impl;


import com.coffee.model.employee.Position;
import com.coffee.repository.IPositionRepository;
import com.coffee.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {
    @Autowired
    private IPositionRepository iPositionRepository;

    /**
     * @param
     * @return Position list
     * @creator TaiLV
     * Date 09/08/2022
     */
    @Override
    public List<Position> getAllPosition() {
        return iPositionRepository.findAllPosition();
    }
}
