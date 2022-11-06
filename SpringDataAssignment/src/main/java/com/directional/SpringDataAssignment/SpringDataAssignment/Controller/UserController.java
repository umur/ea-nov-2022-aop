package com.directional.SpringDataAssignment.SpringDataAssignment.Controller;

import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.User;
import com.directional.SpringDataAssignment.SpringDataAssignment.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {


    public final UserService addressService;

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
       return addressService.getById(id);
    }

    @GetMapping
    public List<User> GetAll() {
       return addressService.getAll();
    }

    @PostMapping
    public void add(@RequestBody User user) {
        addressService.saveOrUpdate(user);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        addressService.saveOrUpdate(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        addressService.delete(id);
    }


}
