package com.example.Product.Review.controller;

import com.example.Product.Review.aspect.annotation.ExecutionTime;
import com.example.Product.Review.entities.User;
import com.example.Product.Review.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping
    @ExecutionTime
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public User getById(@PathVariable long id) {
        return userService.findById(id);
    }

    @PostMapping
    @ExecutionTime
    public void create(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        userService.update(user);
    }

    @DeleteMapping
    public void delete(@RequestBody User user) {
        userService.delete(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        userService.deleteById(id);
    }

}
