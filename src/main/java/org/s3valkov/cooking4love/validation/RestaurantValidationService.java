package org.s3valkov.cooking4love.validation;

import org.s3valkov.cooking4love.domain.models.service.RestaurantServiceModel;

public interface RestaurantValidationService  {
    boolean isRestaurantValid(RestaurantServiceModel restaurantServiceModel);
}
