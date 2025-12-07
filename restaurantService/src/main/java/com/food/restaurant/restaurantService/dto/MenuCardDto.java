package com.food.restaurant.restaurantService.dto;

import lombok.Data;

import java.util.List;

@Data
public class MenuCardDto {
    private Long restaurantId;
    private String title;
    private String description;
    private Boolean isActive;
    private List<MenuCardItemDto> items;
}
