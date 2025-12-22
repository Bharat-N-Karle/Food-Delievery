package com.food.restaurant.restaurantService.service.serviceImpl;

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

import java.util.*;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepo restaurantRepo;
    private final ModelMapper modelMapper;
    @Override
    public void addRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant =
                modelMapper
                        .map(restaurantDto, Restaurant.class);
        MenuCardDto menuCardDto =
                restaurantDto
                        .getMenuCardDto();
        MenuCard menuCard = modelMapper.map(menuCardDto, MenuCard.class);
        List<MenuCardItemDto> menuCardItemDtoList =
                menuCardDto
                        .getItems();

        List<MenuCardItem> menuCardList = menuCardItemDtoList
                .stream()
                .filter(Objects::nonNull)
                .map(dto -> {
                    MenuCardItem item = modelMapper.map(dto, MenuCardItem.class);
                    item.setMenuCard(menuCard);
                    return item;
                })
                .toList();
        menuCard.setItems(menuCardList);
        menuCard.setRestaurant(restaurant);
        restaurant.setMenuCard(menuCard);
        restaurantRepo.save(restaurant);
    }

    @Override
    public RestaurantDto getRestaurantById(Long id) {
        if(id == null){
            throw new NullPointerException("null is not allowed as a id");
        }
        Restaurant restaurant =
                restaurantRepo
                        .findByIdWithMenu(id)
                        .orElseThrow(()->new RuntimeException("Restaurant not found"));
        RestaurantDto restaurantDto =
                modelMapper
                        .map(restaurant, RestaurantDto.class);
        MenuCard menuCard =
                restaurant
                        .getMenuCard();
        MenuCardDto menuCardDto1 =
                modelMapper
                        .map(menuCard, MenuCardDto.class);
        List<MenuCardItem> menuCardItems =
                menuCard
                        .getItems();
        List<MenuCardItemDto> menuCardItemDtoList = menuCardItems
                .stream()
                .filter(Objects::nonNull)
                .map(item -> modelMapper.map(item, MenuCardItemDto.class))
                .toList();
        menuCardDto1.setItems(menuCardItemDtoList);
        restaurantDto.setMenuCardDto(menuCardDto1);
        return restaurantDto;
    }

    @Override
    public List<RestaurantDto> getAllRestaurant() {
        List<Restaurant> restaurantList = restaurantRepo.findAllWithMenu();

        List<RestaurantDto> restaurantDtoList = new ArrayList<>();
        for (Restaurant restaurant : restaurantList){
            RestaurantDto restaurantDto =
                    modelMapper
                            .map(restaurant, RestaurantDto.class);
            MenuCard menuCard =
                    restaurant
                            .getMenuCard();
            MenuCardDto menuCardDto =
                    modelMapper
                            .map(menuCard, MenuCardDto.class);
            List<MenuCardItemDto> itemDto = menuCard
                    .getItems()
                    .stream()
                    .map(item -> modelMapper.map(item, MenuCardItemDto.class))
                    .toList();

            menuCardDto.setItems(itemDto);
            restaurantDto.setMenuCardDto(menuCardDto);
            restaurantDtoList.add(restaurantDto);
        }
        return restaurantDtoList;
    }

    @Override
    public RestaurantDto getRestaurantByName(String name) {
        Restaurant byRestaurantName = restaurantRepo
                .findByName(name)
                .orElseThrow();
        MenuCard menuCard =
                byRestaurantName
                        .getMenuCard();
        MenuCardDto menuCardDto =
                modelMapper
                        .map(menuCard, MenuCardDto.class);
        List<MenuCardItemDto> menuCardItems = Optional
                .ofNullable(menuCard.getItems())
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .map(item -> modelMapper.map(item, MenuCardItemDto.class))
                .toList();

        menuCardDto.setItems(menuCardItems);
        RestaurantDto map = modelMapper.map(byRestaurantName, RestaurantDto.class);
        map.setMenuCardDto(menuCardDto);
        return map;
    }
}
