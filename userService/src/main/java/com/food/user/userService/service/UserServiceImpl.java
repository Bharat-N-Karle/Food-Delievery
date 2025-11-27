package com.food.user.userService.service;

import com.food.user.userService.dto.UserDto;
import com.food.user.userService.dto.UserWithOrders;
import com.food.user.userService.entity.User;
import com.food.user.userService.repository.UserRepository;
import com.food.user.userService.service.servicerepo.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final WebClient.Builder webClient;

    @Override
    public void createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
    }

    @Override
    public UserDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return modelMapper.map(user, UserDto.class);
    }

    public UserWithOrders getUserWithOrders(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        UserDto userDto = modelMapper.map(user, UserDto.class);
        List<Object> orders = webClient.build()
                .get()
                .uri("http://laptop-p7dcc9j9:8082/api/order/user/{id}", id)
                .retrieve()
                .bodyToFlux(Object.class)
                .collectList()
                .block();
        return new UserWithOrders(userDto, orders) ;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        Iterator<User> iterator = users.iterator();
        List<UserDto> userDtoList = new ArrayList<>();
        while (iterator.hasNext()){
            UserDto userDto = modelMapper.map(iterator.next(), UserDto.class);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public void updateOrCreateNew(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow();
        modelMapper.map(userDto, user);
    }
}
