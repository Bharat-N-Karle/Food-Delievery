package com.food.user.userService.service.serviceInterface;

import com.food.user.userService.dto.UserRequest;
import com.food.user.userService.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest userRequest);

/*
    UserResponse updateUser(Long userId, UserRequest userRequest);
*/

    UserResponse getUserById(Long userId);

    UserResponse getUserByUsername(String username);

    List<UserResponse> getAllUsers();

    void deleteUser(Long userId);
}
