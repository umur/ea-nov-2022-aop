package com.aop.springaop.springdatabidirectional.service;


import com.aop.springaop.springdatabidirectional.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User updateUser(User user);
    User getById(Long id);
    void deleteUser(Long id);
    List<User> getAll();
}
