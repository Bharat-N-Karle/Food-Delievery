package com.food.orders.ordersService.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class OrderDto {

    @NotNull
    private Long id;

    @NotNull
    private Long userId;

    @NotNull
    private String name;

}
