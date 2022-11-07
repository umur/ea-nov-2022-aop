package edu.miu.eanov2022aop.repository;

import edu.miu.eanov2022aop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();

    User getReferenceById(Long id);



}
