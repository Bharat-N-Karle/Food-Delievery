package com.food.restaurant.restaurantService.controller;

import com.food.restaurant.restaurantService.dto.MenuCardItemDto;
import com.food.restaurant.restaurantService.service.serviceInter.MenuCardItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurant")
public class MenuController {

        private final MenuCardItemService menuCardItemService;

        @GetMapping("/getRestaurant/{id}/{itemName}")
        public ResponseEntity<MenuCardItemDto> getMenuCardItem(
                @PathVariable Long id,
                @PathVariable String itemName
        ){
            MenuCardItemDto menuCardItem = menuCardItemService.getMenuCardItem(id, itemName);
            return ResponseEntity
                    .status(200)
                    .body(menuCardItem);
        }

    @GetMapping("/getMenuItem/{id}")
    public ResponseEntity<MenuCardItemDto> getMenuCardItem(
            @PathVariable("id") Long id
    ){
        MenuCardItemDto menuCardItem =
                menuCardItemService
                        .getMenuCardItemById(id);
        return ResponseEntity
                .status(200)
                .body(menuCardItem);
    }
}
