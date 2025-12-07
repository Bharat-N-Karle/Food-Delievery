package com.food.restaurant.restaurantService.service;

import com.food.restaurant.restaurantService.dto.MenuCardDto;
import com.food.restaurant.restaurantService.dto.MenuCardItemDto;
import com.food.restaurant.restaurantService.dto.RestaurantDto;
import com.food.restaurant.restaurantService.entity.MenuCard;
import com.food.restaurant.restaurantService.entity.MenuCardItem;
import com.food.restaurant.restaurantService.entity.Restaurant;
import com.food.restaurant.restaurantService.repository.RestaurantRepo;
import com.food.restaurant.restaurantService.service.serviceInter.RestaurantService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepo restaurantRepo;
    private final ModelMapper modelMapper;
    @Override
    public void addRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = modelMapper.map(restaurantDto, Restaurant.class);
        MenuCardDto menuCardDto = restaurantDto.getMenuCardDto();
        MenuCard menuCard = modelMapper.map(menuCardDto, MenuCard.class);
        List<MenuCardItem> menuCardList = new ArrayList<>();
        List<MenuCardItemDto> menuCardItemDtoList = menuCardDto.getItems();
        for (MenuCardItemDto menuCardItemDto : menuCardItemDtoList){
            MenuCardItem menuCardItem = modelMapper.map(menuCardItemDto, MenuCardItem.class);
            menuCardItem.setMenuCard(menuCard);
            menuCardList.add(menuCardItem);
        }
        menuCard.setItems(menuCardList);
        menuCard.setRestaurant(restaurant);
        restaurant.setMenuCard(menuCard);
        restaurantRepo.save(restaurant);
    }

    @Override
    public RestaurantDto getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepo.findById(id).orElseThrow();
        return modelMapper.map(restaurant, RestaurantDto.class);
    }

    @Override
    public List<RestaurantDto> getAllRestaurant() {
        List<Restaurant> restaurantList = restaurantRepo.findAllWithMenu();

        List<RestaurantDto> restaurantDtoList = new ArrayList<>();
        for (Restaurant restaurant : restaurantList){
            RestaurantDto restaurantDto = modelMapper.map(restaurant, RestaurantDto.class);

            MenuCard menuCard = restaurant.getMenuCard();
            MenuCardDto menuCardDto = modelMapper.map(menuCard, MenuCardDto.class);

            List<MenuCardItemDto> itemDtos = menuCard.getItems()
                    .stream()
                    .map(item -> modelMapper.map(item, MenuCardItemDto.class))
                    .toList();

            menuCardDto.setItems(itemDtos);
            restaurantDto.setMenuCardDto(menuCardDto);
            restaurantDtoList.add(restaurantDto);
        }
        return restaurantDtoList;
    }
}
