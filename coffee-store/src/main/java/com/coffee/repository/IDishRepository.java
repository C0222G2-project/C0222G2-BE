package com.coffee.repository;

import com.coffee.model.dish.Dish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IDishRepository extends JpaRepository<Dish, Integer> {
    @Transactional
    @Modifying
    @Query(value = " INSERT INTO dish (`dish_type_id`, image, `name`, code, price) " +
            " VALUES (:#{#dish.dishType.id}, :#{#dish.image}, :#{#dish.name}, :#{#dish.code}, " +
            " :#{#dish.price}); ", nativeQuery = true)
    void saveDish(Dish dish);

    @Query(value = "select dish_id from dish where dish_id = :id", nativeQuery = true)
    Optional<Dish> findByIdDish(@Param("id") int id);


    @Modifying
    @Transactional
    @Query(value = " update dish set `name`= ?, image = ?, code = ?, email = ? , price = ?, " +
            " dish_type_id = ?", nativeQuery = true)
    Dish editDish(Dish dish);

}
