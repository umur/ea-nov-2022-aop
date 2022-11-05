package com.example.springaop.services;

import com.example.springaop.entities.DTOs.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDTO create(UserDTO userDTO);

    List<UserDTO> getAll();

    UserDTO getById(Long id);
}
