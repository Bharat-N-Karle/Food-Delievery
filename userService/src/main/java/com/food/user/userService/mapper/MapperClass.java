package com.food.user.userService.mapper;

import com.food.user.userService.dto.AddressDTO;
import com.food.user.userService.dto.UserRequest;
import com.food.user.userService.dto.UserResponse;
import com.food.user.userService.entity.Address;
import com.food.user.userService.entity.Role;
import com.food.user.userService.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MapperClass {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public User userRequestToUser(UserRequest userRequest) {

        User user = modelMapper.map(userRequest, User.class);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        List<Address> addresses = Optional.ofNullable(userRequest.getAddressDTOS())
                .orElse(List.of())
                .stream()
                .map(dto -> {
                    Address address = modelMapper.map(dto, Address.class);
                    address.setUser(user);
                    return address;
                })
                .toList();
        user.setAddresses(addresses);

        List<Role> roles = Optional.ofNullable(userRequest.getRoleDTOS())
                .orElse(List.of())
                .stream()
                .map(dto -> modelMapper.map(dto, Role.class))
                .toList();
        user.setRoles(roles);

        return user;
    }

    public UserResponse userToUserResponse(User user) {

        UserResponse response = modelMapper.map(user, UserResponse.class);
        List<AddressDTO> addressDto = Optional.ofNullable(user.getAddresses())
                .orElse(List.of())
                .stream()
                .map(add -> modelMapper.map(add, AddressDTO.class))
                .toList();
        response.setAddressDTOS(addressDto);
        return response;
    }
}