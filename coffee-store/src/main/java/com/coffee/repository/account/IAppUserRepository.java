package com.coffee.repository.account;

import com.coffee.model.account.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {

    @Query(value = " select au.id, au.is_deleted, au.password, au.user_name from app_user au where au.user_name = :username ",
            nativeQuery = true)
    AppUser getAppUserByUsername(@Param("username") String username);
}
