package com.example.Product.Review.service.impl;

import com.example.Product.Review.ResponseCreator;
import com.example.Product.Review.entities.join_column.User;
import com.example.Product.Review.repo.UserRepo;
import com.example.Product.Review.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepo userRepo;


    @Override
    public List<User> findAll() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public void update(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void delete(User user) {
        userRepo.delete(user);
    }
}
