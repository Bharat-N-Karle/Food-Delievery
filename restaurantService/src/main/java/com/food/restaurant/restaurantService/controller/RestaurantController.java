package com.food.restaurant.restaurantService.controller;

import com.food.restaurant.restaurantService.dto.RestaurantDto;
import com.food.restaurant.restaurantService.service.serviceInter.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantServiceImpl;

    @PostMapping("/addRestaurant")
    public ResponseEntity<String> addRestaurant(
            @RequestBody
            RestaurantDto restaurantDto){
        restaurantServiceImpl
                .addRestaurant(restaurantDto);
        return ResponseEntity
                .status(201)
                .body("Restaurant Added Successfully");
    }

    @GetMapping("/getRestaurant/{id}")
    public ResponseEntity<RestaurantDto> getRestaurant(
            @PathVariable
            Long id){
        RestaurantDto restaurantDto = restaurantServiceImpl.getRestaurantById(id);
        return ResponseEntity
                .status(200)
                .body(restaurantDto);
    }

    @GetMapping("/getAllRestaurant")
    public ResponseEntity<List<RestaurantDto>> getAllRestaurant(){
        List<RestaurantDto> allRestaurant = restaurantServiceImpl.getAllRestaurant();
        return ResponseEntity
                .status(200)
                .body(allRestaurant);
    }

    @GetMapping("/getRestaurantByName/{name}")
    public ResponseEntity<RestaurantDto> getRestaurantByName(@PathVariable String name){
        RestaurantDto restaurantByName = restaurantServiceImpl.getRestaurantByName(name);
        return ResponseEntity
                .status(200)
                .body(restaurantByName);
    }
}
