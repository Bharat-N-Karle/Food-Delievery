package com.food.orders.ordersService.service.serviceImpl;

import com.food.orders.ordersService.dto.MenuCardItemDto;
import com.food.orders.ordersService.dto.OrderDto;
import com.food.orders.ordersService.entity.Order;
import com.food.orders.ordersService.enumPa.OrderStatus;
import com.food.orders.ordersService.repository.CartRepository;
import com.food.orders.ordersService.repository.OrderRepository;
import com.food.orders.ordersService.service.serviceInter.CartService;
import com.food.orders.ordersService.service.serviceInter.OrderService;
import com.food.orders.ordersService.service.serviceInter.PaymentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final CartRepository cartRepository;
    private final CartService cartService;
    private final PaymentService paymentService;
    private final ModelMapper modelMapper;
    private final OrderRepository orderRepository;

    @Override
    public String placedOrder() {
        if(paymentService.isPaymentDone()){
            cartRepository.deleteAll();
            return "Order Placed";
        }
        else {
            return "Order not placed";
        }
    }

    @Override
    public String createOrder(OrderDto orderDto) {
        Order order =
                modelMapper
                        .map(orderDto, Order.class);
        orderRepository
                .save(order);
        return "Order Created Successfully";
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository
                .findAll()
                .stream()
                .map(order -> modelMapper.map(order,OrderDto.class))
                .toList();
    }

    @Override
    public OrderDto getOrderByStatus(OrderStatus orderStatus) {
        return modelMapper
                .map(
                        orderRepository
                                .findByOrderStatus(orderStatus),OrderDto.class);
    }

    @Override
    public OrderDto updateOrderStatus(Long id, OrderStatus orderStatus) {
        Order order = orderRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException());
        order.setOrderStatus(orderStatus);
        orderRepository.save(order);
        return modelMapper.map(order, OrderDto.class);
    }
}
