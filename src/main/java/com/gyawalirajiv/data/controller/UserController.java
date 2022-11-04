package com.gyawalirajiv.data.controller;

import com.gyawalirajiv.data.models.DTOs.UserDTO;
import com.gyawalirajiv.data.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDTO save(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }

    @GetMapping
    public List<UserDTO> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO find(@PathVariable Long id){
        return userService.find(id);
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return userService.update(id, userDTO);
    }

    @DeleteMapping("/{id}")
    public UserDTO delete(@PathVariable Long id){
        return userService.delete(id);
    }

}
