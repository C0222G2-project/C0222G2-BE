package com.coffee.service.position;

import com.coffee.model.employee.Position;
import com.coffee.repository.position.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {
    @Autowired
    private IPositionRepository iPositionRepository;
    /**
     * @creator ThongNV
     * Date 10/08/2022
     * @param
     * @return  Position list
     */
    @Override
    public List<Position> getAllPosition() {
        return iPositionRepository.findAllPosition();
    }
}
