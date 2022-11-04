package com.example.eanov2022springdataI.repository;

import com.example.eanov2022springdataI.entity.Users;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepositoryInterface<Users> {

}
