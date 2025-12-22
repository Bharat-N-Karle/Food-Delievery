package com.food.orders.ordersService.dto;

import com.food.orders.ordersService.enumPa.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long orderId;

    private Long userId;

    private Double amount;

    private OrderStatus orderStatus;
}
