package com.coffee.repository;

import com.coffee.model.dish.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IDishRepository extends JpaRepository<Dish, Integer> {
    @Query(value = "select id,`code`,creation_date,image,is_deleted,`name`,price,dish_type_id FROM dish ", nativeQuery = true)
    Page<Dish> findAll(Pageable pageable);
}
