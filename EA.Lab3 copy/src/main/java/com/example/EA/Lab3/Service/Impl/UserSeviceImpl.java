package com.example.EA.Lab3.Service.Impl;

import com.example.EA.Lab3.DTO.UserDTO;
import com.example.EA.Lab3.Entity.User;
import com.example.EA.Lab3.Repo.UserRepo;
import com.example.EA.Lab3.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSeviceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    public List<UserDTO> findAll(){
        List<UserDTO> users = new ArrayList<>();
        userRepo.findAll().forEach(user -> users.add(modelMapper.map(user, UserDTO.class)));
        return users;
    }

    public UserDTO save(UserDTO user){
        User mappedUser = modelMapper.map(user, User.class);
        return modelMapper.map(userRepo.save(mappedUser), UserDTO.class);
    }
    public UserDTO update(Long id, UserDTO user){
        User mappedUser = modelMapper.map(user, User.class);
        return modelMapper.map(userRepo.save(mappedUser), UserDTO.class);
    }
    public void delete(Long id){
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("Invelid ID !"));
        userRepo.delete(user);
        //modelMapper.map(user, UserDTO.class);
    }

}
