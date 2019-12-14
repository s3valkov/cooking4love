package org.s3valkov.cooking4love.validation.impl;

import org.s3valkov.cooking4love.domain.models.service.RestaurantServiceModel;
import org.s3valkov.cooking4love.validation.RestaurantValidationService;
import org.springframework.stereotype.Component;

@Component
public class RestaurantValidationServiceImpl implements RestaurantValidationService {
    @Override
    public boolean isRestaurantValid(RestaurantServiceModel restaurantServiceModel) {
        return restaurantServiceModel != null;
    }
}
