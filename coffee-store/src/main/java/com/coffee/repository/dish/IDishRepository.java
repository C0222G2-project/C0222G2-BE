package com.coffee.repository.dish;

import com.coffee.model.dish.Dish;
import com.coffee.model.dish.DishType;
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
public interface IDishRepository extends JpaRepository<Dish, Integer> {
    @Query(value = "SELECT id,`code`,creation_date,image,is_deleted,`name`,price,dish_type_id FROM dish d where d.is_deleted = 0", nativeQuery = true)
    Page<Dish> selectAllDishPage(Pageable pageable);

    @Query(value = " SELECT d.id,d.`code`,d.creation_date,d.image,d.is_deleted,d.`name`,d.price,d.dish_type_id " +
            "FROM dish d " +
            "join dish_type on d.dish_type_id = dish_type.id " +
            "where d.name like :name and d.code like :code and d.price like :price and dish_type.`id` like :dishType and d.is_deleted = 0", nativeQuery = true,
            countQuery = " select count(*) from(SELECT id,`code`,creation_date,image," +
                    "d.is_deleted,`name`,price,dish_type_id FROM dish d " +
                    "where d.name like :name and d.code like :code and d.price like :price and dish_type.`id` like :dishType and d.is_deleted = 0) temp_table")
    Page<Dish> searchDishPage(@Param("name") String name, @Param("code") String code, @Param("price") String price, @Param("dishType") String dishType, Pageable pageable);


    @Query(value = "SELECT id,`code`,creation_date,image,is_deleted,`name`,price,dish_type_id  from dish d where d.id =:dishId", nativeQuery = true)
    Dish selectDishById(@Param("dishId") Integer id);

    @Modifying
    @Query(value = " update dish d set is_deleted = 1 where  d.id =:dishId and d.is_deleted = 0", nativeQuery = true)
    int deleteDishById(@Param("dishId") Integer id);
}
