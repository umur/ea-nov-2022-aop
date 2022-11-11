package com.AssignmentThree.Service.Implemintation;

import com.AssignmentThree.DTO.UserName;
import com.AssignmentThree.Entities.Users;
import com.AssignmentThree.Reposotory.UserRepo;
import com.AssignmentThree.Service.UsersService;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public void add(Users user){
        userRepo.save(user);
    }

    @Override
    public List<Users> getAll(){
        return userRepo.findAll();
    }

    @Override
    public Optional<Users> findById(Integer userID){
        return userRepo.findById(userID);
    }

    public UserName getUserName(int userId){
        return modelMapper.map(userRepo.findById(userId).get(), UserName.class);
    }

    public List<UserName> getAllUsersName(){
        return userRepo.findAll().stream().map(user-> modelMapper.map(user,UserName.class)).collect(Collectors.toList());
    }


}
