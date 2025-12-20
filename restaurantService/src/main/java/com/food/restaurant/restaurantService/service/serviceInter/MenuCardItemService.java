package com.food.restaurant.restaurantService.service.serviceInter;

import com.food.restaurant.restaurantService.dto.MenuCardItemDto;

public interface MenuCardItemService {

    MenuCardItemDto getMenuCardItem(Long restaurantId, String itemName);

    MenuCardItemDto getMenuCardItemById(Long menuCardId);

}
