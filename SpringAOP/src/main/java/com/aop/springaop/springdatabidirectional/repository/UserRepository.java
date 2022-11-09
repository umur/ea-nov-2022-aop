package com.aop.springaop.springdatabidirectional.repository;


import com.aop.springaop.springdatabidirectional.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
