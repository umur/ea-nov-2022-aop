package com.example.eanov2022aop.service;

import com.example.eanov2022aop.entity.Users;
import com.example.eanov2022aop.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService extends CrudService<Users,UserRepository>{

    public UserService(UserRepository repository) {
        super(repository);
    }
}
