package com.example.springaop.services.impl;

import com.example.springaop.aop.annotations.ExecutionTime;
import com.example.springaop.entities.DTOs.UserDTO;
import com.example.springaop.entities.User;
import com.example.springaop.repositories.UserRepo;
import com.example.springaop.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @ExecutionTime
    @Override
    public UserDTO create(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return modelMapper.map(userRepo.save(user), UserDTO.class);
    }

    @ExecutionTime
    @Override
    public List<UserDTO> getAll() {
        return userRepo.findAll().stream().map(m -> modelMapper.map(m, UserDTO.class)).collect(Collectors.toList());
    }

    @ExecutionTime
    @Override
    public UserDTO getById(Long id) {
        return modelMapper.map(userRepo.findById(id), UserDTO.class);
    }
}
