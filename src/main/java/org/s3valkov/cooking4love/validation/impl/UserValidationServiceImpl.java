package org.s3valkov.cooking4love.validation.impl;

import org.s3valkov.cooking4love.domain.models.service.UserServiceModel;
import org.s3valkov.cooking4love.validation.UserValidationService;
import org.springframework.stereotype.Component;

@Component
public class UserValidationServiceImpl implements UserValidationService {
    @Override
    public boolean isUserValid(UserServiceModel userServiceModel) {
        return userServiceModel != null;
    }
}
