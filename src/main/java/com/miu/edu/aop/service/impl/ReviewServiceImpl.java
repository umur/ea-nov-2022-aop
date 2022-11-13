package com.miu.edu.aop.service.impl;

import com.miu.edu.aop.annotation.ExecutionTime;
import com.miu.edu.aop.dto.ReviewDto;
import com.miu.edu.aop.entity.Review;
import com.miu.edu.aop.repository.ReviewRepository;
import com.miu.edu.aop.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    @ExecutionTime
    public List<ReviewDto> getReviewsByProductId(int productId) {
        return reviewRepository.getAllByProductId(productId).stream().map(ReviewDto::convertFrom).toList();
    }

    @Override
    @ExecutionTime
    public ReviewDto getReviewById(int id) {
        return ReviewDto.convertFrom(reviewRepository.findById(id).orElse(null));
    }

    @Override
    public void updateReview(int id, ReviewDto review) {
        reviewRepository.findById(id).ifPresent(r -> {
            r.setComment(review.getComment());
            reviewRepository.save(r);
        });
    }

    @Override
    public ReviewDto addReview(ReviewDto reviewDto) {
        return ReviewDto.convertFrom(reviewRepository.save(ReviewDto.convertTo(reviewDto)));
    }

    @Override
    public void removeById(int id) {
        reviewRepository.deleteById(id);
    }
}
