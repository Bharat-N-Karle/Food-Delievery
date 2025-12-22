package com.food.orders.ordersService.service.serviceImpl;

import com.food.orders.ordersService.dto.MenuCardItemDto;
import com.food.orders.ordersService.entity.Cart;
import com.food.orders.ordersService.interfaces.CartFeignClient;
import com.food.orders.ordersService.repository.CartRepository;
import com.food.orders.ordersService.service.serviceInter.CartPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartPriceServiceImpl implements CartPriceService {

    private final CartRepository cartRepository;
    private final CartFeignClient cartFeignClient;

    @Override
    public Double totalAmount() {
        List<Cart> cartList = cartRepository.findAll();
        Double totalAmountSum = 0.0;
        for(Cart cart : cartList){
            MenuCardItemDto menuCardItemDto =
                    cartFeignClient
                            .getMenuCardItem(cart.getMenuCardItemId())
                            .getBody();
            totalAmountSum+= menuCardItemDto.getPrice();
        }
        return totalAmountSum;
    }
}
