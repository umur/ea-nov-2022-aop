package com.AssignmentThree.Reposotory;

import com.AssignmentThree.Entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends CrudRepository<Users, Integer> {

    List<Users> findAll();

    Optional<Users> findById(Integer userId);

}
