package com.food.orders.ordersService.controller;

import com.food.orders.ordersService.service.serviceImpl.CartPriceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/price")
public class CartPriceController {

    private final CartPriceServiceImpl cartPriceService;

    @GetMapping("/getTotal")
    public ResponseEntity<Double> getTotalCartAmount(){
        return ResponseEntity
                .status(200)
                .body(cartPriceService.totalAmount());
    }
}
