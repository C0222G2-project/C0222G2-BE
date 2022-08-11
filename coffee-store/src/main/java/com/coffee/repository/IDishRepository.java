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
    @Query(value = " INSERT INTO dish (`dish_type_id`, image, `name`, code, price, creation_date) " +
            " VALUES (:#{#dish.dishType.id}, :#{#dish.image}, :#{#dish.name}, :#{#dish.code}, " +
            " :#{#dish.price}, :#{#dish.creationDate} ); ", nativeQuery = true)
    void saveDish(Dish dish);

    @Query(value = "select * from dish where id = :id", nativeQuery = true)
    Optional<Dish> findByIdDish(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = " update dish set `name`= :#{#dish.name}, image = :#{#dish.image}, code = :#{#dish.code},  price = :#{#dish.price}, creation_date = :#{#dish.creationDate}, is_deleted = :#{#dish.isDeleted}, dish_type_id = :#{#dish.dishType.id} where id= :#{#dish.id}",
            nativeQuery = true)
    void editDish(Dish dish);

}
