package com.food.user.userService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String firstName;

    private String lastName;

    private String userName;

    private String email;

    private String password;

    private Long phoneNumber;

    private Integer age;

    private List<AddressDTO> addressDTOS;

    private List<RoleDTO> roleDTOS;
}
