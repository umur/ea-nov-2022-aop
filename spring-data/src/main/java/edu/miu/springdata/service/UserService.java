package edu.miu.springdata.service;

import edu.miu.springdata.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void save(User user);

    void delete(Long userId);

    User getById(Long userId);

    List<User> getAll();

}
