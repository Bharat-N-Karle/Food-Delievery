package com.food.orders.ordersService.service.serviceInter;

import com.food.orders.ordersService.dto.MenuCardItemDto;

import java.util.List;

public interface OrderService {

    void addToCart(Long menuItemId);

    String deleteFromCart(Long id);

    MenuCardItemDto getMenuCardItem(Long menuId, String itemName);

    List<MenuCardItemDto> getAllItemsFromCart();

}
