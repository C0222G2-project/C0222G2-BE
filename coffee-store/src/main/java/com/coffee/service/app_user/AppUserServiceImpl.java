package com.coffee.service.app_user;

import com.coffee.repository.app_user.IAppUserRepository;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements IAppUserService {
    private IAppUserRepository iAppUserRepository;
}
