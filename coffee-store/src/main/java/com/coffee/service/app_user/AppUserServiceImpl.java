package com.coffee.service.app_user;

import com.coffee.dto.AppUserDto;
import com.coffee.model.account.AppUser;
import com.coffee.repository.app_user.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements IAppUserService {
    @Autowired
    private IAppUserRepository iAppUserRepository;
}
