package com.waa.springdata.controller;

import com.waa.springdata.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {


    public UserController(){
    }
    
    @GetMapping
    public List<UserDto> getUsers() {
        return null;
    }
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable int id) {return null;
    }
}
