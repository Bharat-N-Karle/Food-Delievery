package com.food.restaurant.restaurantService.service.serviceInter;

import com.food.restaurant.restaurantService.dto.RestaurantDto;
import com.food.restaurant.restaurantService.entity.Restaurant;

import java.util.List;

public interface RestaurantService {

    void addRestaurant(RestaurantDto restaurantDto);

    RestaurantDto getRestaurantById(Long id);

    List<RestaurantDto> getAllRestaurant();

}
