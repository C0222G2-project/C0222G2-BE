package com.coffee.service.impl;

import com.coffee.model.dish.Dish;
import com.coffee.repository.IDishRepository;
import com.coffee.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DishService implements IDishService {
    @Autowired
    private IDishRepository iDishRepository;

    /**
     * @function ( create new Dish)
     * @param dish
     * @return dish, status 201
     * @creator PhucLV
     * @date-create 09/08/2022
     */
    @Override
    public void save(Dish dish) {
        iDishRepository.saveDish(dish);
    }
    /**
     * @function ( find the dish of the id )
     * @creator PhucLV
     * @date-create 09/08/2022
     * @param id
     * @return  id
     */

    @Override
    public Optional<Dish> findById(int id) {
        return iDishRepository.findByIdDish(id);
    }

    /**
     * @function ( edit the value of the dish)
     * @creator PhucLV
     * @date-create 09/08/2022
     * @param dish
     * @return dish
     */

    @Override
    public Dish editDish(Dish dish) {
        return iDishRepository.editDish(dish);
    }
}
