package com.AssignmentThree.Controller;

import com.AssignmentThree.DTO.UserName;
import com.AssignmentThree.Reposotory.UserRepo;
import com.AssignmentThree.Service.Implemintation.UsersServiceImpl;
import com.AssignmentThree.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("user")
@RestController
public class UsersController {

    @Autowired
    UsersServiceImpl userServ ;

    @GetMapping("username")
    public UserName getUsername(int userId){
        return userServ.getUserName(userId);
    }

    @GetMapping("allusersnames")
    public List<UserName> getAllUserNames(){
        return userServ.getAllUsersName();
    }
}
