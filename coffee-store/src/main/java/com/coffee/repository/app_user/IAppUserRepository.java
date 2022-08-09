package com.coffee.repository.app_user;

import com.coffee.model.account.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Integer> {
}
