package com.example.Product.Review.service;

import com.example.Product.Review.entities.join_column.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();
    User findById(long id);
    void save(User user);
    void update(User user);
    void deleteById(long id);
    void delete(User user);

}
