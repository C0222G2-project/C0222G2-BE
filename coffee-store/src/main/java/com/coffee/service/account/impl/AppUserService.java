package com.coffee.service.account.impl;

import com.coffee.model.account.AppUser;
import com.coffee.repository.account.IAppUserRepository;
import com.coffee.service.account.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements IAppUserService {

    @Autowired
    private IAppUserRepository IAppUserRepository;

    /**
     * Method get AppUser by username
     * @param username
     * @return AppUser
     */
    @Override
    public AppUser findAppUserByUsername(String username) {
        return this.IAppUserRepository.getAppUserByUsername(username);
    }
}
