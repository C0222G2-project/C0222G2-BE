package com.coffee.repository;

import com.coffee.model.account.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IAppUserRepository extends JpaRepository<AppUser, Integer> {
    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param
     * @return  AppUser list
     */
<<<<<<< HEAD
    @Query(value = " select app_user.id, app_user.username, app_user.password, app_user.is_deleted from app_user " +
            " where is_deleted = 0 ", nativeQuery = true)
=======
    @Query(value = " select app_user.id, app_user.name, app_user.password from app_user where is_deleted = 0 ", nativeQuery = true)
>>>>>>> ccede6118b6e623b7883bb907d99172b0c46d9ee
    List<AppUser> findAllUser();
}
