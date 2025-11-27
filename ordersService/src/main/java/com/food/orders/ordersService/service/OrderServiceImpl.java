package com.food.orders.ordersService.service;

import com.food.orders.ordersService.dto.OrderDto;
import com.food.orders.ordersService.dto.OrderWithRestaurantDto;
import com.food.orders.ordersService.entity.Order;
import com.food.orders.ordersService.repository.OrderRepository;
import com.food.orders.ordersService.service.serviceInte.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final WebClient.Builder webClient;

    @Override
    public void placedOrder(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);
        orderRepository.save(order);
    }

    @Override
    public OrderDto getOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow();
        return modelMapper.map(order, OrderDto.class);
    }

    public OrderWithRestaurantDto getOrderWithRestaurants(Long id){
        Order order = orderRepository.findById(id).orElseThrow();
        OrderDto orderDto = modelMapper.map(order, OrderDto.class);
        List<Object> restaurant = webClient.build()
                .get()
                .uri("http://RESTAURANTSERVICE/api/restaurant/getRestaurantByOrderId/{orderId}", id)
                .retrieve()
                .bodyToFlux(Object.class)
                .collectList()
                .block();
        return new OrderWithRestaurantDto(orderDto, restaurant);
    }

    @Override
    public List<OrderDto> getAllOrdersByUserID(Long userId){
        List<Order> orderList = orderRepository.findByUserId(userId);
        Iterator<Order> iterator = orderList.iterator();
        List<OrderDto> orderDtoList = new ArrayList<>();
        while (iterator.hasNext()){
            OrderDto orderDto = modelMapper.map(iterator.next(), OrderDto.class);
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orderList = orderRepository.findAll();
        Iterator<Order> iterator = orderList.iterator();
        List<OrderDto> orderDtoList = new ArrayList<>();
        while (iterator.hasNext()){
            OrderDto orderDto = modelMapper.map(iterator.next(), OrderDto.class);
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }
}
