package com.example.EA.Lab3.Service;

import com.example.EA.Lab3.DTO.UserDTO;
import com.example.EA.Lab3.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

     List<UserDTO> findAll();
     UserDTO save(UserDTO user);
     UserDTO update(Long id, UserDTO user);
     void delete(Long id);
}
