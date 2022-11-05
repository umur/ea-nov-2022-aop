package com.miu.edu.aop.repository;

import com.miu.edu.aop.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {

    List<Review> getAllByProductId(int productId);
}
