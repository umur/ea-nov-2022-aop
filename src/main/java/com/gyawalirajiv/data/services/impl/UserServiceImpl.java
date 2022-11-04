package com.gyawalirajiv.data.services.impl;

import com.gyawalirajiv.data.models.DTOs.UserDTO;
import com.gyawalirajiv.data.models.User;
import com.gyawalirajiv.data.repository.UserRepository;
import com.gyawalirajiv.data.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDTO save(UserDTO userDTO) {
        return modelMapper.map(userRepository.save(modelMapper.map(userDTO, User.class)), UserDTO.class);
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(u -> modelMapper.map(u, UserDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UserDTO find(Long id) {
        return modelMapper.map(userRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID!")), UserDTO.class);
    }

    @Override
    public UserDTO update(Long id, UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID!"));
        userRepository.delete(user);
        return modelMapper.map(user, UserDTO.class);
    }
}
