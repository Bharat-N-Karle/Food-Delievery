package com.food.orders.ordersService.controller;

import com.food.orders.ordersService.dto.OrderDto;
import com.food.orders.ordersService.enumPa.OrderStatus;
import com.food.orders.ordersService.service.serviceInter.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderStatusController {

    private final OrderService orderService;

    @PostMapping("/addOrder")
    public ResponseEntity<String> addOrder(@RequestBody OrderDto orderDto){
        return ResponseEntity
                .status(201)
                .body(orderService.createOrder(orderDto));
    }

    @GetMapping("/getOrderByStatus/{orderStatus}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable OrderStatus orderStatus){
        return ResponseEntity
                .status(200)
                .body(orderService.getOrderByStatus(orderStatus));
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        return ResponseEntity
                .status(200)
                .body(orderService.getAllOrders());
    }

    @PutMapping("/updateStatus/{id}/{orderStatus}")
    public ResponseEntity<OrderDto> updateOrderStatus(
            @PathVariable Long id,
            @PathVariable OrderStatus orderStatus){
        return ResponseEntity
                .status(200)
                .body(orderService.updateOrderStatus(id, orderStatus));
    }
}
