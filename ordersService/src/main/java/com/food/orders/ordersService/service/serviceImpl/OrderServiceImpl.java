package com.food.orders.ordersService.service.serviceImpl;

import com.food.orders.ordersService.dto.MenuCardItemDto;
import com.food.orders.ordersService.dto.OrderDto;
import com.food.orders.ordersService.entity.Order;
import com.food.orders.ordersService.interfaces.OrderFeignClient;
import com.food.orders.ordersService.repository.OrderRepository;
import com.food.orders.ordersService.service.serviceInter.OrderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderFeignClient orderFeignClient;
    private final OrderRepository orderRepository;


    @Override
    public void addToCart(Long menuItemId) {
        Long id = orderFeignClient.getMenuCardItem(menuItemId).getBody().getId();
        Order order = new Order();
        order.setMenuCardItemId(id);
        orderRepository.save(order);
    }

    @Override
    public String deleteFromCart(Long id) {
        orderRepository.deleteById(id);
        return "Deleted from Cart";
    }

    @Override
    public MenuCardItemDto getMenuCardItem(Long menuId, String itemName) {
        return orderFeignClient
                .getMenuCardItem(menuId, itemName)
                .getBody();
    }

    @Override
    public List<MenuCardItemDto> getAllItemsFromCart() {
        List<Order> allOrder = orderRepository.findAll();
        List<MenuCardItemDto> list = new ArrayList<>();
        for (Order order : allOrder){
            Long menuCardItemId =
                    order
                            .getMenuCardItemId();
            list
                    .add(
                            orderFeignClient
                            .getMenuCardItem(menuCardItemId)
                                    .getBody()
                    );
        }
        return list;
    }
}
