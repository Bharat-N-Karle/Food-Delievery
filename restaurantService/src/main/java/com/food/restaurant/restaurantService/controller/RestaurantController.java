package com.food.restaurant.restaurantService.controller;

import com.food.restaurant.restaurantService.dto.RestaurantDto;
import com.food.restaurant.restaurantService.service.RestaurantServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
@AllArgsConstructor
public class RestaurantController {

    private final RestaurantServiceImpl restaurantServiceImpl;

    @PostMapping("/addRestaurant")
    public ResponseEntity<String> addRestaurant(@RequestBody RestaurantDto restaurantDto){
        restaurantServiceImpl.addRestaurant(restaurantDto);
        return ResponseEntity.ok("Restaurant added successfully");
    }

    @GetMapping("/getRestaurant/{id}")
    public ResponseEntity<RestaurantDto> getRestaurant(@PathVariable Long id){
        RestaurantDto restaurantDto = restaurantServiceImpl.getRestaurantById(id);
        return ResponseEntity.ok(restaurantDto);
    }

    @GetMapping("/getRestaurantByOrderId/{orderId}")
    public ResponseEntity<RestaurantDto> getRestaurantByOrder(@PathVariable Long orderId){
        RestaurantDto restaurantDto = restaurantServiceImpl.getRestaurantByOrderId(orderId);
        return ResponseEntity.ok(restaurantDto);
    }

    @GetMapping("/getAllRestaurant")
    public ResponseEntity<List<RestaurantDto>> getAllRestaurant(){
        List<RestaurantDto> allRestaurant = restaurantServiceImpl.getAllRestaurant();
        return ResponseEntity.ok(allRestaurant);
    }
}
