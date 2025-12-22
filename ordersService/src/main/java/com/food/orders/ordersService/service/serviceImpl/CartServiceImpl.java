package com.food.orders.ordersService.service.serviceImpl;

import com.food.orders.ordersService.dto.MenuCardItemDto;
import com.food.orders.ordersService.entity.Cart;
import com.food.orders.ordersService.interfaces.CartFeignClient;
import com.food.orders.ordersService.repository.CartRepository;
import com.food.orders.ordersService.service.serviceInter.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartFeignClient orderFeignClient;
    private final CartRepository cartRepository;


    @Override
    public void addToCart(Long menuItemId) {
        Long id = orderFeignClient.getMenuCardItem(menuItemId).getBody().getId();
        Cart order = new Cart();
        order.setMenuCardItemId(id);
        cartRepository.save(order);
    }

    @Override
    public String deleteFromCart(Long id) {
        cartRepository.deleteById(id);
        return "Deleted from Cart";
    }

    @Override
    public MenuCardItemDto getMenuCardItemById(Long id) {
        return orderFeignClient
                .getMenuCardItem(id)
                .getBody();
    }

    @Override
    public List<MenuCardItemDto> getAllItemsFromCart() {
        List<Cart> allOrder = cartRepository.findAll();
        List<MenuCardItemDto> list = new ArrayList<>();
        for (Cart cart : allOrder){
            Long menuCardItemId =
                    cart.getMenuCardItemId();
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
