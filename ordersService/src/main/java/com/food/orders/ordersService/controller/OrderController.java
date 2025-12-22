package com.food.orders.ordersService.controller;

import com.food.orders.ordersService.service.serviceInter.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/placedOrder")
    public ResponseEntity<String> orderPlaced() {
        return ResponseEntity
                .status(200)
                .body(orderService.placedOrder());
    }
}
