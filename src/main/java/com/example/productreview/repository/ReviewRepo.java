package com.example.productreview.repository;

import com.example.productreview.entity.uni_and_bi_directional.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Long> {
    List<Review> findAll();
    List<Review> findAllByProductId(Long id);
}
