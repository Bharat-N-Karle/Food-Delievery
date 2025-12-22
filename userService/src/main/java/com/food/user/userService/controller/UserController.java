package com.food.user.userService.controller;

import com.food.user.userService.dto.UserRequest;
import com.food.user.userService.dto.UserResponse;
import com.food.user.userService.service.serviceInterface.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    /*@PutMapping("/update/{userId}")
    public ResponseEntity<UserResponse> updateData(@PathVariable Long userId, @RequestBody UserRequest userRequest){
        return ResponseEntity
                .status(200)
                .body(userService.updateUser(userId,userRequest));
    }*/

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<UserResponse> userById(@PathVariable Long userId){
        return ResponseEntity
                .status(200)
                .body(userService.getUserById(userId));
    }

    @GetMapping("/getUser/{userName}")
    public ResponseEntity<UserResponse> userByUserName(@PathVariable String userName){
        return ResponseEntity
                .status(200)
                .body(userService.getUserByUsername(userName)
                );
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserResponse>> allUsers(){
        return ResponseEntity
                .status(200)
                .body(userService.getAllUsers());
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return ResponseEntity
                .status(200)
                .body("user deleted SuccessFully");
    }
}
