package com.food.user.userService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long id;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private Long postalCode;

    private boolean isDefault;
}
