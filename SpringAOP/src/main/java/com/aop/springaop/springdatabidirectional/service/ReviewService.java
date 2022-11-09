package com.aop.springaop.springdatabidirectional.service;



import com.aop.springaop.springdatabidirectional.entity.Review;

import java.util.List;

public interface ReviewService {
    Review save(Review review);
    Review updateReview(Review review);
    Review getById(Long id);
    void deleteReview(Long id);
    List<Review> getAll();
    List<Review> findReviewByIdIs(Long id);
}
