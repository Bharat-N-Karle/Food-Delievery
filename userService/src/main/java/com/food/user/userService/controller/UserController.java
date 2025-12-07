package com.food.user.userService.controller;

import com.food.user.userService.dto.UserDto;
import com.food.user.userService.dto.UserWithOrders;
import com.food.user.userService.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@ResponseBody
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @PostMapping("/addUser")
    public ResponseEntity<UserDto> addUser(@RequestBody
                                               UserDto userDto){
        userServiceImpl.createUser(userDto);
        return ResponseEntity.status(201).body(userDto);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable
                                               Long id){
        UserDto userDto = userServiceImpl.getUser(id);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/getUsersOrder/{id}")
    public ResponseEntity<UserWithOrders> getUsersAllOrder(@PathVariable Long id){
        UserWithOrders userWithOrders = userServiceImpl.getUserWithOrders(id);
        return ResponseEntity.ok(userWithOrders);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userServiceImpl.getAllUsers());
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        userServiceImpl.deleteUser(id);
        return ResponseEntity.ok("User with given id deleted");
    }

    @DeleteMapping("/deleteAllUsers")
    public ResponseEntity<String> deleteAllUsers(){
        userServiceImpl.deleteAllUsers();
        return ResponseEntity.ok("All Users Deleted");
    }

    @PutMapping("/updateOrCreate/{id}")
    public ResponseEntity<UserDto> updateOrCreate(@PathVariable Long id ,@RequestBody UserDto userDto){
        userServiceImpl.updateOrCreateNew(id,userDto);
        return ResponseEntity.ok(userDto);
    }
}
