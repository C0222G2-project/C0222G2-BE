package com.coffee.repository;

import com.coffee.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
    @Query(value = "select * from position where is_deleted = 0", nativeQuery = true)
    List<Position> findAll();
}
