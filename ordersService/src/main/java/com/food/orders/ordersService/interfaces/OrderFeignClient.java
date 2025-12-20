package com.food.orders.ordersService.interfaces;

import com.food.orders.ordersService.dto.MenuCardItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RESTAURANTSERVICE")

public interface OrderFeignClient {

    @GetMapping("/api/restaurant/getRestaurant/{id}/{itemName}")
    ResponseEntity<MenuCardItemDto> getMenuCardItem(
            @PathVariable Long id,
            @PathVariable String itemName
    );

    @GetMapping("/api/restaurant/getMenuItem/{id}")
    public ResponseEntity<MenuCardItemDto> getMenuCardItem(
            @PathVariable Long id
    );
}
