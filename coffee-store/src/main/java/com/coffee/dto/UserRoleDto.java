package com.coffee.dto;

import com.coffee.model.account.AppRole;
import com.coffee.model.account.AppUser;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class UserRoleDto {
    private Integer id;

    private Boolean isDeleted;
    private AppUser appUser;

    private AppRole appRole;
}
