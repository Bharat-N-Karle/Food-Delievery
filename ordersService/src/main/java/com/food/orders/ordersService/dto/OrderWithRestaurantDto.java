package com.food.orders.ordersService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderWithRestaurantDto {

    Object order;
    List<Object> restaurant;
}
