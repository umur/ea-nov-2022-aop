package com.example.lab3springdata.service.Impl;

import com.example.lab3springdata.model.uni_directional.Review;
import com.example.lab3springdata.repo.ReviewRepository;
import org.springframework.stereotype.Service;
import com.example.lab3springdata.service.ReviewService;

import java.util.List;


@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAll() {
        return (List<Review>) reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(int id) {
        return reviewRepository.findById(id).get();
    }

    @Override
    public void create(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public Review update(int id, Review review) {
        Review reviewById = reviewRepository.findById(id).get();
        reviewById.setId(review.getId());
        reviewById.setComment(review.getComment());
        reviewById.setProduct(review.getProduct());
        reviewRepository.save(reviewById);
        return reviewById;
    }

    @Override
    public void delete(int id) {
        Review reviewById = reviewRepository.findById(id).get();
        reviewRepository.delete(reviewById);
    }


    // extra

    @Override
    public List<Review> getReviewsByProductId(int id) {
        return reviewRepository.findAllByProduct_Id(id);
    }
}
