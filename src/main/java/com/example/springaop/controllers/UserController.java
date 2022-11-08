package com.example.springaop.controllers;

import com.example.springaop.entities.DTOs.UserDTO;
import com.example.springaop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    ResponseEntity<?> create(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.create(userDTO), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<?> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }
}
