package com.example.productreview.repository;

import com.example.productreview.entity.uni_and_bi_directional.User_;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User_, Long> {
    List<User_> findAll();
}
