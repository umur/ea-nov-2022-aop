package com.example.Product.Review.service.impl;

import com.example.Product.Review.entities.join_column.Review;
import com.example.Product.Review.repo.ReviewRepo;
import com.example.Product.Review.service.IReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService implements IReviewService {

    private final ReviewRepo reviewRepo;

    @Override
    public List<Review> findAll() {
        return (List<Review>) reviewRepo.findAll();
    }

    @Override
    public Review findById(long id) {
        return reviewRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public void update(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public void deleteById(long id) {
        reviewRepo.deleteById(id);
    }

    @Override
    public void delete(Review review) {
        reviewRepo.delete(review);
    }

    @Override
    public List<Review> findReviewsByProductId(long id) {
        return reviewRepo.findReviewsByProductId(id);
    }
}
