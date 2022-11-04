package com.example.lab3.service;

import com.example.lab3.dto.ReviewDto;
import com.example.lab3.entity.bidirectional.Review;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> getAll();
    ReviewDto getReviewById(Long id);
    ReviewDto saveReview(Review review);
    ReviewDto updateReview(Long id, Review review);
    void deleteReviewById(Long id);
}
