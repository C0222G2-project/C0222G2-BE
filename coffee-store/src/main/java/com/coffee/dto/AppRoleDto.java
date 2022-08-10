package com.coffee.dto;

import com.coffee.model.account.UserRole;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class AppRoleDto {
    private Integer id;

    private String roleName;

    private List<UserRole> userRoles;

    private Boolean isDeleted;
}
