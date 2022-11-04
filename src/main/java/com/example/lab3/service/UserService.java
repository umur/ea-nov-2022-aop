package com.example.lab3.service;

import com.example.lab3.dto.UserDto;
import com.example.lab3.entity.bidirectional.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    UserDto getUserById(Long id);

    UserDto saveUser(User user);

    UserDto updateUser(Long id, User user);

    void deleteUserById(Long id);
}
