package com.food.orders.ordersService.controller;

import com.food.orders.ordersService.dto.OrderDto;
import com.food.orders.ordersService.dto.OrderWithRestaurantDto;
import com.food.orders.ordersService.service.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderServiceImpl orderServiceImpl;

    @PostMapping("/placeOrder")
    public ResponseEntity<Void> createOrder(@RequestBody OrderDto orderDto){
        orderServiceImpl.placedOrder(orderDto);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/getOrder/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id){
        OrderDto orderDto = orderServiceImpl.getOrder(id);
        return ResponseEntity.status(201).body(orderDto);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<OrderDto>> getAllOrdersByUserID(@PathVariable("id") Long userId){
        List<OrderDto> orderDtoList = orderServiceImpl.getAllOrdersByUserID(userId);
        return ResponseEntity.status(201).body(orderDtoList);
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<OrderWithRestaurantDto> getOrderWithRestaurant(@PathVariable Long id){
        return ResponseEntity.ok(orderServiceImpl.getOrderWithRestaurants(id));
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        List<OrderDto> orderDtoList = orderServiceImpl.getAllOrders();
        return ResponseEntity.status(201).body(orderDtoList);
    }
}
