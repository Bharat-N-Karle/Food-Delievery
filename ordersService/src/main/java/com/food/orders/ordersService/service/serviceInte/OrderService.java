package com.food.orders.ordersService.service.serviceInte;

import com.food.orders.ordersService.dto.OrderDto;

import java.util.List;

public interface OrderService {

    void placedOrder(OrderDto orderDto);

    OrderDto getOrder(Long id);

    List<OrderDto> getAllOrdersByUserID(Long userID);

    List<OrderDto> getAllOrders();
}
