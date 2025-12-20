package com.food.orders.ordersService.controller;

import com.food.orders.ordersService.dto.MenuCardItemDto;
import com.food.orders.ordersService.dto.OrderDto;
import com.food.orders.ordersService.interfaces.OrderFeignClient;
import com.food.orders.ordersService.service.serviceInter.OrderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cart")
public class CartController {

    private final OrderService orderService;

    @PostMapping("/addCart/{menuItemId}")
    public ResponseEntity<String> addToCart(
            @PathVariable Long menuItemId){
        orderService.addToCart(menuItemId);
        return ResponseEntity
                .status(201)
                .body("Added to the Cart");
    }

    @GetMapping("/getItem/{id}/{itemName}")
    public ResponseEntity<MenuCardItemDto> getItemById(
            @PathVariable Long id,
            @PathVariable String itemName){
        return ResponseEntity
                .status(200)
                .body(orderService.getMenuCardItem(id,itemName));
    }

    @GetMapping("/getAllItemFromCart")
    public ResponseEntity<List<MenuCardItemDto>> getAllMenuItemsFromCart(){
        return ResponseEntity
                .status(200)
                .body(orderService.getAllItemsFromCart());
    }
}
