package com.example.eanov2022aop.repository;

import com.example.eanov2022aop.entity.Users;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepositoryInterface<Users> {

}
