package com.coffee.service.impl;

import com.coffee.model.dish.Dish;
import com.coffee.repository.dish.IDishRepository;
import com.coffee.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DishService implements IDishService {
    @Autowired
    private IDishRepository iDishRepository;

    /**
     * Created By: HieuCD
     * Date created: 09/08/2022
     * function: get dish page
     * @param pageable
     * @return
     */
    @Override
    public Page<Dish> findAllDish(Pageable pageable) {
        return iDishRepository.selectAllDishPage(pageable);
    }

    /**
     * Created By: HieuCD
     * Date created: 09/08/2022
     * function: get dish by dish id
     * @param id
     * @return
     */
    @Override
    public Dish findDishById(Integer id) {
        return iDishRepository.selectDishById(id);
    }

    /**
     * Created By: HieuCD
     * Date created: 09/08/2022
     * function: delete dish by dish id
     * @param id
     */
    @Override
    public void deleteDish(Integer id) {
        iDishRepository.deleteDishById(id);
    }
}
