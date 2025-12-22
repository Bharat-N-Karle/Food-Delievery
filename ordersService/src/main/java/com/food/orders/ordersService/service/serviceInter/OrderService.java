package com.food.orders.ordersService.service.serviceInter;


import com.food.orders.ordersService.dto.OrderDto;
import com.food.orders.ordersService.enumPa.OrderStatus;

import java.util.List;

public interface OrderService {

    String placedOrder();

    String createOrder(OrderDto orderDto);

    List<OrderDto> getAllOrders();

    OrderDto getOrderByStatus(OrderStatus orderStatus);

    OrderDto updateOrderStatus(Long id, OrderStatus orderStatus);
}
