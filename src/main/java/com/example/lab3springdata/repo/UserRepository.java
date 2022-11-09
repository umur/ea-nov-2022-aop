package com.example.lab3springdata.repo;

import com.example.lab3springdata.model.uni_directional.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {
}
