package com.example.lab3.service.impl;

import com.example.lab3.dto.ReviewDto;
import com.example.lab3.dto.UserDto;
import com.example.lab3.entity.bidirectional.Review;
import com.example.lab3.entity.bidirectional.User;
import com.example.lab3.mapper.Mapper;
import com.example.lab3.repository.UserRepo;
import com.example.lab3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    private Mapper mapper = new Mapper<User, UserDto>(User.class, UserDto.class);
    @Override
    public List<UserDto> getAll() {
        return mapper.toListDto((List<User>) userRepo.findAll());
    }

    @Override
    public UserDto getUserById(Long id) {
        return (UserDto) mapper.toDto(userRepo.findById(id).get());
    }

    @Override
    public UserDto saveUser(User user) {
        return (UserDto) mapper.toDto(userRepo.save(user));
    }

    @Override
    public UserDto updateUser(Long id, User u) {
        User user = userRepo.findById(id).get();
        if (Objects.nonNull(u.getAddress())) {
            user.setAddress(u.getAddress());
        }
        if (Objects.nonNull(u.getEmail())) {
            user.setEmail(u.getEmail());
        }
        if (Objects.nonNull(u.getFirstName())) {
            user.setFirstName(u.getFirstName());
        }
        if (Objects.nonNull(u.getLastName())) {
            user.setLastName(u.getLastName());
        }
        if (Objects.nonNull(u.getPassword())) {
            user.setPassword(u.getPassword());
        }
        if (Objects.nonNull(u.getReviews())) {
            user.setReviews(u.getReviews());
        }
        return (UserDto) mapper.toDto(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepo.deleteById(id);
    }

}
