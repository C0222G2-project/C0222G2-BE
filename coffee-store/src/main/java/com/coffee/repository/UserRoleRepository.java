package com.coffee.repository;

import com.coffee.model.account.AppUser;
import com.coffee.model.account.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findAllByAppUser(AppUser appUser);
}
