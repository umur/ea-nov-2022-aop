package com.example.EA.Lab3.Controller;

import com.example.EA.Lab3.DTO.UserDTO;
import com.example.EA.Lab3.Entity.User;
import com.example.EA.Lab3.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDTO> findAll(){
        return userService.findAll();
    }
    @PostMapping
    public UserDTO save(@RequestBody UserDTO user){
        return userService.save(user);
    }
    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody UserDTO user){
        return userService.update(id, user);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
