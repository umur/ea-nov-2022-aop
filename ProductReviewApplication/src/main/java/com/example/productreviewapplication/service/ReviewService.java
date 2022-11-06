package com.example.productreviewapplication.service;

import com.example.productreviewapplication.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    public void addReview(Review review);
    public Review updateReview(Integer id, String comment);
    public void deleteReview(Integer id);
    public Iterable<Review> getAllReviews();
    public Review getReviewById(Integer id);
    public List<Review> findReviewsByProductId(Integer id);
}
