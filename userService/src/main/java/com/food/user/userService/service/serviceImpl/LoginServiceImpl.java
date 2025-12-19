package com.food.user.userService.service.serviceImpl;

import com.food.user.userService.dto.LoginRequestDTO;
import com.food.user.userService.entity.User;
import com.food.user.userService.repository.UserRepository;
import com.food.user.userService.service.serviceInterface.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    public final UserRepository userRepository;

    @Override
    public String loginAccess(LoginRequestDTO loginRequestDTO) {
        String username = loginRequestDTO.getUsername();
        String password = loginRequestDTO.getPassword();
        Optional<User> userOptional = userRepository.findByUserName(username);
        if(userOptional.get().getPassword().equals(password)){
            return "Logged in Successfully";
        }
        else {
            return "invalid credentials";
        }
    }
}
