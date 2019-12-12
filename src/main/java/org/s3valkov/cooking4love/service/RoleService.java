package org.s3valkov.cooking4love.service;

import org.s3valkov.cooking4love.domain.models.service.RoleServiceModel;

import java.util.Set;

public interface RoleService {

    void seedRoles();

    Set<RoleServiceModel> findAllRoles();

    RoleServiceModel findByAuthority(String authority);
}
