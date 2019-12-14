package org.s3valkov.cooking4love.validation;

import org.s3valkov.cooking4love.domain.models.service.UserServiceModel;

public interface UserValidationService {

    boolean isUserValid(UserServiceModel userServiceModel);
}
