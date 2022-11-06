package com.AssignmentThree.Service;

import com.AssignmentThree.Entities.Users;
import org.apache.catalina.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    void add(Users user) ;

    List<Users> getAll();

    Optional<Users> findById(Integer userID);

}
