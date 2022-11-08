package com.example.productreview.controller;

import com.example.productreview.aspect.annotation.ExecutionTime;
import com.example.productreview.entity.DTO.UserAddressDTO;
import com.example.productreview.entity.uni_and_bi_directional.User_;
import com.example.productreview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    @ExecutionTime
    List<User_> findAll(){
        return userService.findAll();
    }

    @GetMapping("/address")
    @ExecutionTime
    List<UserAddressDTO> findAllUserAddress(){
        return userService.findAllUserAddress();
    }
    @PostMapping
    String save(@RequestBody User_ user){
        userService.add(user);
        return "User Saved!!!";
    }
    @PutMapping("/{id}")
    String update(@PathVariable Long id, @RequestBody User_ user){
        User_ oldUser;
        try{
            oldUser = userService.findById(id);
        }catch (Exception exception){
            return "Error -> " + exception.toString();
        }
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setAddress(user.getAddress());

        userService.add(oldUser);
        return "User updated!!!";
    }

    @DeleteMapping("/{id}")
    String delete(@PathVariable Long id){
        try{
            userService.delete(id);
        }catch (Exception exception){
            return "Error -> " + exception.toString();
        }
        return "User delete!!!";
    }

}
