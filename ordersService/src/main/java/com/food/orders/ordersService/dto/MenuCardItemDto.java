package com.food.orders.ordersService.dto;

import lombok.Data;

@Data
public class MenuCardItemDto {
    private Long id;
    private String itemName;
    private String description;
    private String category;
    private Double price;
    private Boolean veg;
    private Boolean available;
}
