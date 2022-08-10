package com.coffee.repository;

import com.coffee.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPositionRepository extends JpaRepository<Position, Integer> {
    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param
     * @return  Position list
     */
<<<<<<< HEAD
    @Query(value = " select `position`.id, `position`.name, `position`.is_deleted from `position` " +
            " where `position`.is_deleted = 0 ", nativeQuery = true)
=======
    @Query(value = " select `position`.id, `position`.name from `position` where is_deleted = 0 ", nativeQuery = true)
>>>>>>> ccede6118b6e623b7883bb907d99172b0c46d9ee
    List<Position> findAllPosition();
}
