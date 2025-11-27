package com.food.restaurant.restaurantService.service;

import com.food.restaurant.restaurantService.dto.RestaurantDto;
import com.food.restaurant.restaurantService.entity.Restaurant;
import com.food.restaurant.restaurantService.repository.RestaurantRepo;
import com.food.restaurant.restaurantService.service.serviceInter.RestaurantService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepo restaurantRepo;
    private final ModelMapper modelMapper;
    @Override
    public void addRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = modelMapper.map(restaurantDto, Restaurant.class);
        restaurantRepo.save(restaurant);
    }

    @Override
    public RestaurantDto getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepo.findById(id).orElseThrow();
        return modelMapper.map(restaurant, RestaurantDto.class);
    }

    @Override
    public RestaurantDto getRestaurantByOrderId(Long orderId) {
        Restaurant restaurant = restaurantRepo.findById(orderId).orElseThrow();
        return modelMapper.map(restaurant, RestaurantDto.class);
    }

    @Override
    public List<RestaurantDto> getAllRestaurant() {
        List<Restaurant> restaurantList = restaurantRepo.findAll();
        Iterator<Restaurant> iterator = restaurantList.iterator();
        List<RestaurantDto> restaurantDto = new ArrayList<>();
        while (iterator.hasNext()){
            RestaurantDto restaurantDto1 = modelMapper.map(iterator.next(), RestaurantDto.class);
            restaurantDto.add(restaurantDto1);
        }
        return restaurantDto;
    }
}
