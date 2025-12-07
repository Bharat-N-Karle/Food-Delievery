package com.food.restaurant.restaurantService.request;


import lombok.Data;

@Data
public class MenuCardItemRequest {
    private String itemName;
    private String description;
    private String category;
    private Double price;
    private Boolean veg = true;
    private Boolean available = true;
    private String imageUrl;
}