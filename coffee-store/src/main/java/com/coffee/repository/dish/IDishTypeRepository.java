package com.coffee.repository.dish;

import com.coffee.model.dish.DishType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IDishTypeRepository extends JpaRepository<DishType, Integer> {
    @Query(value = " select * from dish_type", nativeQuery = true)
    Page<DishType> selectAllDishTypePage(Pageable pageable);

    @Query(value = " select * from dish_type b where b.dish_id =:dishId", nativeQuery = true)
    DishType selectDishById(@Param("dishId") Integer id);

    @Modifying
    @Query(value = " update dish_type d set is_deleted=1 where  d.dish_id =:dishId", nativeQuery = true)
    int deleteDishTypeById(@Param("dishId") Integer id);
}
