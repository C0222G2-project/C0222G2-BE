package com.coffee.service.impl;

import com.coffee.model.dish.DishType;
import com.coffee.repository.dish.IDishTypeRepository;
import com.coffee.service.IDishTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DishTypeService implements IDishTypeService {
    @Autowired
    private IDishTypeRepository iDishTypeRepository;

    /**
     * Created By: HieuCD
     * Date created: 09/08/2022
     * function: get dish by dish id
     * @param pageable
     * @return Page<DishType> dishPage
     */
    @Override
    public Page<DishType> findAllDishType(Pageable pageable) {
        return iDishTypeRepository.selectAllDishTypePage(pageable);
    }

    /**
     * Created By: HieuCD
     * Date created: 09/08/2022
     * function: get dish by dish id
     * @param id
     * @return dish
     */
    @Override
    public DishType findDishTypeById(Integer id) {
        return iDishTypeRepository.selectDishById(id);
    }

}
