package com.food.orders.ordersService.service.serviceInter;

import com.food.orders.ordersService.dto.MenuCardItemDto;

import java.util.List;

public interface CartService {

    void addToCart(Long menuItemId);

    String deleteFromCart(Long id);

    MenuCardItemDto getMenuCardItemById(Long id);

    List<MenuCardItemDto> getAllItemsFromCart();

}
