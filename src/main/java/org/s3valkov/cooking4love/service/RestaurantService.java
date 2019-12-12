package org.s3valkov.cooking4love.service;

import org.s3valkov.cooking4love.domain.models.service.RestaurantServiceModel;

import java.util.List;

public interface RestaurantService {

    RestaurantServiceModel createRestaurant(RestaurantServiceModel restaurantServiceModel);

    RestaurantServiceModel findRestaurantByName(String name);

    List<RestaurantServiceModel> findAllRestaurants();

    RestaurantServiceModel findRestaurantById(String id);

    void deleteRestaurant(String id);

    RestaurantServiceModel editRestaurant(String id, RestaurantServiceModel restaurantServiceModel);
}
