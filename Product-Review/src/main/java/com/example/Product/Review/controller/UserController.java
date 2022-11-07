package com.example.Product.Review.controller;

import com.example.Product.Review.entities.join_column.User;
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
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable long id) {
        return userService.findById(id);
    }

    @PostMapping
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
