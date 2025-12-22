package com.food.restaurant.restaurantService.service.serviceImpl;

import com.food.restaurant.restaurantService.dto.MenuCardItemDto;
import com.food.restaurant.restaurantService.entity.MenuCardItem;
import com.food.restaurant.restaurantService.repository.MenuCardRepository;
import com.food.restaurant.restaurantService.service.serviceInter.MenuCardItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuCardItemServiceImpl implements MenuCardItemService {

    private final MenuCardRepository menuCardRepository;
    private final ModelMapper modelMapper;

    @Override
    public MenuCardItemDto getMenuCardItem(Long id, String itemName) {
        MenuCardItem menuCardItem = menuCardRepository
                .findByMenuCardIdAndItemName(id, itemName)
                .orElseThrow(
                        ()->new RuntimeException("Menu item not found with id")
                );
        return modelMapper
                .map(menuCardItem, MenuCardItemDto.class);
    }

    @Override
    public MenuCardItemDto getMenuCardItemById(Long menuCardId) {
        MenuCardItem menuCardItem = menuCardRepository
                .findById(menuCardId)
                .orElseThrow(
                        ()->new RuntimeException("Menu item not found with id")
        );
        return modelMapper
                .map(menuCardItem, MenuCardItemDto.class);
    }

}
