package com.coffee.repository.app_user;

import com.coffee.model.account.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IAppUserRepository extends JpaRepository<AppUser, Integer> {
    @Query(value = "select app_user.user_name, app_user.password " +
    "from app_user " +
    "where app_user.id = ? ", nativeQuery = true)
    Optional<AppUser> findAppUserById(Integer id);
    @Query(value = "update app_user u set u.password = ? where u.id = ?", nativeQuery = true)
    void update(AppUser appUser);
}
