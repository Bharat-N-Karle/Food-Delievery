package com.food.user.userService.controller;

import com.food.user.userService.dto.UserRequest;
import com.food.user.userService.dto.UserResponse;
import com.food.user.userService.service.serviceInterface.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SignUpController {

    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userRequest){
        return ResponseEntity
                .status(201)
                .body(userService.createUser(userRequest));
    }
}
