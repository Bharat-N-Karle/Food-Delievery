package com.food.orders.ordersService.controller;

import com.food.orders.ordersService.dto.MenuCardItemDto;
import com.food.orders.ordersService.service.serviceInter.CartService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    @PostMapping("/addCart/{menuItemId}")
    public ResponseEntity<String> addToCart(
            @PathVariable Long menuItemId){
        cartService.addToCart(menuItemId);
        return ResponseEntity
                .status(201)
                .body("Added to the Cart");
    }

    @GetMapping("/getAllItemFromCart")
    public ResponseEntity<List<MenuCardItemDto>> getAllMenuItemsFromCart(){
        return ResponseEntity
                .status(200)
                .body(cartService.getAllItemsFromCart());
    }

    @GetMapping("/getCartItem/{id}")
    public ResponseEntity<MenuCardItemDto> getCartItems(@PathVariable Long id){
        return ResponseEntity
                .status(200)
                .body(cartService.getMenuCardItemById(id));
    }
}
