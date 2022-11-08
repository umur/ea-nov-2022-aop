package com.example.productreview.service;


import com.example.productreview.entity.DTO.UserAddressDTO;
import com.example.productreview.entity.uni_and_bi_directional.User_;

import java.util.List;

public interface UserService {
    List<User_> findAll();

    List<UserAddressDTO> findAllUserAddress();
    User_ findById(Long id);
    void add(User_ user);
    void update(Long id, User_ user);
    void delete(Long id);
}
