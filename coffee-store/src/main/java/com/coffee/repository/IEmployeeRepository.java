package com.coffee.repository;

import com.coffee.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select * from employee where is_deleted = 0", nativeQuery = true)
    Page<Employee> findAll(Pageable pageable);

    @Query(value = "select * from employee where is_deleted = 0 and id = :id", nativeQuery = true)
    Employee findById(@Param("id") int id);

}
