package com.coffee.service.app_user;

import com.coffee.dto.AppUserDto;
import com.coffee.model.account.AppUser;

public interface IAppUserService {
    AppUserDto findById(Integer id);

    void update(AppUser appUser);
}
