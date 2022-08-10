package com.coffee.repository;

import com.coffee.model.account.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IAppUserRepository extends JpaRepository<AppUser, Integer> {

}
