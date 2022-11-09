package com.aop.springaop.springdatabidirectional.repository;


import com.aop.springaop.springdatabidirectional.entity.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review,Long> {
    @Query("SELECT r FROM Review r WHERE r.id=?1")
    List<Review> findReviewByIdIs(Long id);
}
