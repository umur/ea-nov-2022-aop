package com.aop.springaop.springdatabidirectional.service.Impl;

import com.aop.springaop.springdatabidirectional.entity.Review;
import com.aop.springaop.springdatabidirectional.repository.ReviewRepository;
import com.aop.springaop.springdatabidirectional.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;


    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Review review) {
        return null;
    }

    @Override
    public Review getById(Long id) {
        return reviewRepository.findById(id).get();
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);

    }

    @Override
    public List<Review> getAll() {
        List<Review> reviewList=new ArrayList<>();
        reviewRepository.findAll().forEach(reviewList::add);
        return reviewList;
    }

    @Override
    public List<Review> findReviewByIdIs(Long id) {
        return reviewRepository.findReviewByIdIs(id);
    }
}
