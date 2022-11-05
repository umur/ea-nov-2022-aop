package com.miu.edu.aop.controller;

import com.miu.edu.aop.dto.UserDto;
import com.miu.edu.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping
    public void updateUser(@RequestBody UserDto user) {
        userService.updateUser(user);
    }

    @PostMapping
    public void addUser(@RequestBody UserDto user) {
        userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable int id) {
        userService.removeById(id);
    }
}
