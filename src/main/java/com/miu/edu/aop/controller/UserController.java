package com.miu.edu.aop.controller;

import com.miu.edu.aop.dto.AddressDto;
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

    @GetMapping("/{id}/address")
    public AddressDto getAddressByUserId(@PathVariable int id) {
        return userService.getAddressByUserId(id);
    }
    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id, @RequestBody UserDto user) {
        userService.updateUser(id, user);
    }

    @PostMapping
    public UserDto addUser(@RequestBody UserDto user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable int id) {
        userService.removeById(id);
    }
}
