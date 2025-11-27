package com.food.user.userService.service.servicerepo;

import com.food.user.userService.dto.UserDto;
import com.food.user.userService.entity.User;

import java.util.List;

public interface UserService {

    void createUser(UserDto userDto);

    UserDto getUser(Long id);

    List<UserDto> getAllUsers();

    void deleteUser(Long id);

    void deleteAllUsers();

    void updateOrCreateNew(Long id, UserDto userDto);
}
