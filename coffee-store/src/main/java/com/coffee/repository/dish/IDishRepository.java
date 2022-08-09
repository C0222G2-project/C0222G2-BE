package com.coffee.repository.dish;

import com.coffee.model.dish.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IDishRepository extends JpaRepository<Dish,Integer> {
    @Query(value = "SELECT id,`code`,creation_date,image,is_deleted,`name`,price,dish_type_id FROM dish", nativeQuery = true)
    Page<Dish> selectAllDishPage(Pageable pageable);

    @Query(value = "SELECT id,`code`,creation_date,image,is_deleted,`name`,price,dish_type_id  from dish b where b.dish_id =:dishId", nativeQuery = true)
    Dish selectDishById(@Param("dishId") Integer id);

    @Modifying
    @Query(value = " update dish d set is_deleted=1 where  d.dish_id =:dishId", nativeQuery = true)
    int deleteDishById(@Param("dishId") Integer id);
}
