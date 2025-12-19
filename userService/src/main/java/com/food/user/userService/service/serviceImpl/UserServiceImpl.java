package com.food.user.userService.service.serviceImpl;

import com.food.user.userService.dto.UserRequest;
import com.food.user.userService.dto.UserResponse;
import com.food.user.userService.entity.User;
import com.food.user.userService.mapper.MapperClass;
import com.food.user.userService.repository.UserRepository;
import com.food.user.userService.service.serviceInterface.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;
    public final ModelMapper modelMapper;
    public final MapperClass mapperClass;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = mapperClass.userRequestToUser(userRequest);
        User savedUser = userRepository.save(user);
        return mapperClass.userToUserResponse(savedUser);
    }

    /*@Override
    public UserResponse updateUser(Long userId, UserRequest userRequest) {
        Optional<User> userOptional = userRepository
                .findById(userId);
        User user = null;
        if (userOptional.isPresent()) {
            user = userOptional.get();
        }
        if(user!=null){
            user.setFirstName(userRequest.getFirstName());
            user.setLastName(userRequest.getLastName());
            user.setUserName(userRequest.getUserName());
            user.setEmail(userRequest.getEmail());
            user.setAge(userRequest.getAge());
            user.setPhoneNumber(userRequest.getPhoneNumber());
            user.setPassword(userRequest.getPassword());
            user.setAddresses(
                    userRequest
                            .getAddressDTOS()
                            .stream()
                            .map(addressDTO ->
                                    modelMapper
                                    .map(addressDTO, Address.class)
                            )
                            .collect(Collectors.toList())
            );
            user.setRoles(
                    userRequest
                            .getRoleDTOS()
                            .stream()
                            .map(roleDTO ->
                                    modelMapper
                                            .map(roleDTO,  Role.class)
                            )
                            .collect(Collectors.toList())
            );
        }
        return mapperClass.userToUserResponse(user);
    }*/

    @Override
    public UserResponse getUserById(Long userId) {
        Optional<User> userOptional
                = userRepository
                .findById(userId);
        User user = null;
        if (userOptional.isPresent()) {
            user = userOptional.get();
        }
        return mapperClass
                .userToUserResponse(user);
    }

    @Override
    public UserResponse getUserByUsername(String username) {
        return mapperClass
                .userToUserResponse(
                        userRepository
                                .findByUserName(username)
                                .orElseThrow(
                                        ()->
                                                new UsernameNotFoundException("user not in the database"))
                );
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> allUser = userRepository.findAll();
        List<UserResponse> userResponseList = new ArrayList<>();
        for (User user : allUser){
            userResponseList
                    .add(mapperClass.userToUserResponse(user));
        }
        return userResponseList;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
