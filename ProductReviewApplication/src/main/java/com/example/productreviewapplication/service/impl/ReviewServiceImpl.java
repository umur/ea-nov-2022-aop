package com.example.productreviewapplication.service.impl;

import com.example.productreviewapplication.model.Review;
import com.example.productreviewapplication.repository.ReviewRepository;
import com.example.productreviewapplication.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    public ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Integer id, String comment) {
        Review review = reviewRepository.findById(id).orElse(null);
        if(review != null){
            review.setComment(comment);
        }
        return review;
    }

    @Override
    public void deleteReview(Integer id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Iterable<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(Integer id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public List<Review> findReviewsByProductId(Integer id) {
        return reviewRepository.findReviewsByProduct_Id(id);
    }
}
