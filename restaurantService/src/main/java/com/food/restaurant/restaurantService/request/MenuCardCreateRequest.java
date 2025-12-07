package com.food.restaurant.restaurantService.request;

import lombok.Data;

@Data
public class MenuCardCreateRequest {
    private Long restaurantId;
    private String title;
    private String description;
    private Boolean isActive = true;
}