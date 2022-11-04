package miu.edu.lab4.service;

import miu.edu.lab4.entity.User;
import miu.edu.lab4.repository.UserRepo;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void addUser(User user) {
        userRepo.save(user);
    }

    public User getUserById(int id) {

        return userRepo.findById(id).get();
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepo.findAll();
    }

}
