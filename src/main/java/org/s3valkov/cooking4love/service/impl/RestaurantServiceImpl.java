package org.s3valkov.cooking4love.service.impl;

import org.modelmapper.ModelMapper;
import org.s3valkov.cooking4love.domain.entities.Restaurant;
import org.s3valkov.cooking4love.domain.models.service.RestaurantServiceModel;
import org.s3valkov.cooking4love.error.Constants;
import org.s3valkov.cooking4love.error.exceptions.RecipeNotFoundException;
import org.s3valkov.cooking4love.error.exceptions.RestaurantNotFoundException;
import org.s3valkov.cooking4love.repository.RestaurantRepository;
import org.s3valkov.cooking4love.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final ModelMapper modelMapper;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(ModelMapper modelMapper, RestaurantRepository restaurantRepository) {
        this.modelMapper = modelMapper;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public RestaurantServiceModel createRestaurant(RestaurantServiceModel restaurantServiceModel) {
        Restaurant restaurant = this.modelMapper.map(restaurantServiceModel, Restaurant.class);
        return this.modelMapper.map(this.restaurantRepository.saveAndFlush(restaurant), RestaurantServiceModel.class);
    }

    @Override
    public RestaurantServiceModel findRestaurantByName(String name) {
        return this.restaurantRepository.findByName(name)
                .map(r -> this.modelMapper.map(r, RestaurantServiceModel.class))
                .orElseThrow(() -> new RecipeNotFoundException(Constants.RESTAURANT_NOT_FOUND));
    }

    @Override
    public List<RestaurantServiceModel> findAllRestaurants() {
        return this.restaurantRepository.findAllAndOrderByRate()
                .stream()
                .map(r -> this.modelMapper.map(r, RestaurantServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantServiceModel findRestaurantById(String id) {
        return this.restaurantRepository.findById(id)
                .map(r -> this.modelMapper.map(r, RestaurantServiceModel.class))
                .orElseThrow(() -> new RestaurantNotFoundException(Constants.RESTAURANT_NOT_FOUND));
    }

    @Override
    public void deleteRestaurant(String id) {
        Restaurant restaurant = this.restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(Constants.RESTAURANT_NOT_FOUND));

        this.restaurantRepository.delete(restaurant);
    }

    @Override
    public RestaurantServiceModel editRestaurant(String id, RestaurantServiceModel restaurantServiceModel) {
        Restaurant restaurant = this.restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(Constants.RESTAURANT_NOT_FOUND));

        System.out.println();
        restaurant.setName(restaurantServiceModel.getName());
        restaurant.setLocation(restaurantServiceModel.getLocation());
        restaurant.setRate(restaurantServiceModel.getRate());

        return this.modelMapper.map(this.restaurantRepository.saveAndFlush(restaurant), RestaurantServiceModel.class);
    }
}
