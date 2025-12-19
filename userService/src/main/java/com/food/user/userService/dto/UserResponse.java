package com.food.user.userService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private String firstName;

    private String lastName;

    private String email;

    private Long phoneNumber;

    private Integer age;

    private List<AddressDTO> addressDTOS;
}
