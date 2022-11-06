package edu.miu.eanov2022aop.service.impl;

import edu.miu.eanov2022aop.model.User;
import edu.miu.eanov2022aop.repository.UserRepository;
import edu.miu.eanov2022aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getById(long id) {
        return userRepo.findById(id);
    }

    @Override
    public User add(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateById(long id, User user) {
        User newUser = userRepo.getReferenceById(id);
        newUser.setAddress(user.getAddress());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setReviews(user.getReviews());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        return userRepo.save(newUser);
    }

    @Override
    public void deleteById(long id) {
        userRepo.deleteById(id);
    }
}
