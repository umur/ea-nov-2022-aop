package com.gyawalirajiv.data.services;

import com.gyawalirajiv.data.models.DTOs.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO save(UserDTO userDTO);

    List<UserDTO> findAll();

    UserDTO find(Long id);

    UserDTO update(Long id, UserDTO userDTO);

    UserDTO delete(Long id);
}
