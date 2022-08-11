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
     *
     * @param pageable
     * @return Page<Dish> dishPage
     */
    @Override
    public Page<Dish> findAllDish(Pageable pageable) {
        return iDishRepository.selectAllDishPage(pageable);
    }

    /**
     * Created By: HieuCD
     * Date created: 09/08/2022
     * function: get dish by dish id
     *
     * @param id
     * @return dish
     */
    @Override
    public Dish findDishById(Integer id) {
        return iDishRepository.selectDishById(id);
    }

    /**
     * Created By: HieuCD
     * Date created: 09/08/2022
     * function: delete dish by dish id
     *
     * @param id
     */
    @Override
    public void deleteDish(Integer id) {
        iDishRepository.deleteDishById(id);
    }

    /**
     * Created By: HieuCD
     * Date created: 10/08/2022
     * function: search dish by dish name,code
     *
     * @param name
     * @param code
     * @param price
     * @param dishType
     * @param pageable
     * @return dishPage (search)
     */

    @Override
    public Page<Dish> searchDish(String name, String code, String price, String dishType, Pageable pageable) {
        return iDishRepository.searchDishPage("%" + name + "%", "%" + code + "%", "%" + price + "%", dishType, pageable);
    }
}
