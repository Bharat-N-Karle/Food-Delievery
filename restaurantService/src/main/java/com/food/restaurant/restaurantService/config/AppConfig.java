package com.food.restaurant.restaurantService.config;

import com.food.restaurant.restaurantService.dto.MenuCardDto;
import com.food.restaurant.restaurantService.dto.RestaurantDto;
import com.food.restaurant.restaurantService.entity.MenuCard;
import com.food.restaurant.restaurantService.entity.Restaurant;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(MenuCard.class, MenuCardDto.class)
                .addMappings(mapper -> mapper.skip(MenuCardDto::setItems));
        modelMapper.typeMap(Restaurant.class, RestaurantDto.class)
                .addMappings(mapper -> mapper.skip(RestaurantDto::setMenuCardDto));
        return modelMapper;
    }


}
