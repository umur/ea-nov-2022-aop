package edu.miu.springdata.service.impl;

import edu.miu.springdata.entity.User;
import edu.miu.springdata.repository.UserRepo;
import edu.miu.springdata.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public void delete(Long userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public User getById(Long userId) {
        return userRepo.findById(userId).get();
    }

    @Override
    public List<User> getAll() {
        var userList = new ArrayList<User>();
        userRepo.findAll().forEach(userList::add);

        return userList;
    }
}
