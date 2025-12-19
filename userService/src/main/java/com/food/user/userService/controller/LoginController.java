package com.food.user.userService.controller;

import com.food.user.userService.dto.LoginRequestDTO;
import com.food.user.userService.service.serviceInterface.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoginController {

    public final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<String> giveAccess(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity
                .ok(loginService.loginAccess(loginRequestDTO));
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello Bharat";
    }

}
