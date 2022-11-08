package com.example.productreview.service.Impl;

import com.example.productreview.aspect.annotation.ExecutionTime;
import com.example.productreview.entity.DTO.DTOConverter;
import com.example.productreview.entity.DTO.UserAddressDTO;
import com.example.productreview.entity.uni_and_bi_directional.User_;
import com.example.productreview.repository.UserRepo;
import com.example.productreview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;


    @Override
    public List<User_> findAll() {
        return userRepo.findAll();
    }

    @Override
    public List<UserAddressDTO> findAllUserAddress() {
        DTOConverter dTOConverter = new DTOConverter();
        return userRepo.findAll().stream()
                .map(user -> dTOConverter.userToDTO(user))
                .toList();
    }

    @Override
    public User_ findById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void add(User_ user) {
        userRepo.save(user);
    }

    @Override
    public void update(Long id, User_ user) {
        User_ oldUser = userRepo.findById(id).get();
        oldUser.setAddress(user.getAddress());
        oldUser.setEmail(user.getEmail());
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }
}
