package com.example.eanov2022springdataI.controller;


import com.example.eanov2022springdataI.entity.Users;
import com.example.eanov2022springdataI.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController extends CrudController<Users, UserService>{

    public UserController(UserService service) {
        super(service);
    }
}
