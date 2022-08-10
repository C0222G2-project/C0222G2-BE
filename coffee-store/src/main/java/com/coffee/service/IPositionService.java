package com.coffee.service;

import com.coffee.model.employee.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
}
