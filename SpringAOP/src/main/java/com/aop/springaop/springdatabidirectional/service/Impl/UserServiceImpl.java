package com.aop.springaop.springdatabidirectional.service.Impl;

import com.aop.springaop.springdatabidirectional.entity.User;
import com.aop.springaop.springdatabidirectional.repository.UserRepository;
import com.aop.springaop.springdatabidirectional.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<User> getAll() {
        List<User>userList=new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }
}
