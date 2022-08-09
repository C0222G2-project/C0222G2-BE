package com.coffee.service.position;

import com.coffee.repository.position.IPositionRepository;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements IPositionService {
    private IPositionRepository iPositionRepository;
}
