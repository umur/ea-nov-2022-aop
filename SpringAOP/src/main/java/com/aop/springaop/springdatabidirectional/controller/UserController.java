package com.aop.springaop.springdatabidirectional.controller;

import com.aop.springaop.aspectAdvice.ExecutionTime;
import com.aop.springaop.springdatabidirectional.entity.User;
import com.aop.springaop.springdatabidirectional.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @ExecutionTime
    @GetMapping
    public List<User> getAddress(){
        return userService.getAll();
    }
    @ExecutionTime
    @PostMapping("/save")
    public User saveAddress(@RequestBody User user){
        return userService.save(user);
    }
    @ExecutionTime
    @GetMapping("/{id}")
    public User getAddressById(@PathVariable Long id){
        return userService.getById(id);
    }
    @ExecutionTime
    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
