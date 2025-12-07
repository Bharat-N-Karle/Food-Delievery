package com.food.restaurant.restaurantService.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {

    @NotBlank
    private String name;

    @NotBlank
    private String area;

    private MenuCardDto menuCardDto;
}
