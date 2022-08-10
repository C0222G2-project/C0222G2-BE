package com.coffee.repository.dish;

import com.coffee.model.dish.DishType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface IDishTypeRepository extends JpaRepository<DishType, Integer> {
    @Query(value = " select  id,`code`,is_deleted,`name` from dish_type", nativeQuery = true)
    Page<DishType> selectAllDishTypePage(Pageable pageable);

    @Query(value = " select  id,`code`,is_deleted,`name` from dish_type d where d.id =:dishId", nativeQuery = true)
    DishType selectDishById(@Param("dishId") Integer id);

}
