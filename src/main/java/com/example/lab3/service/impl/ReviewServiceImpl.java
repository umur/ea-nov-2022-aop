package com.example.lab3.service.impl;

import com.example.lab3.dto.CategoryDto;
import com.example.lab3.dto.ReviewDto;
import com.example.lab3.entity.bidirectional.Category;
import com.example.lab3.entity.bidirectional.Review;
import com.example.lab3.mapper.Mapper;
import com.example.lab3.repository.ReviewRepo;
import com.example.lab3.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;
    private Mapper mapper = new Mapper<Review, ReviewDto>(Review.class, ReviewDto.class);
    @Override
    public List<ReviewDto> getAll() {
        return mapper.toListDto((List<Review>) reviewRepo.findAll());
    }

    @Override
    public ReviewDto getReviewById(Long id) {
        return (ReviewDto) mapper.toDto(reviewRepo.findById(id).get());
    }

    @Override
    public ReviewDto saveReview(Review review) {
        return (ReviewDto) mapper.toDto(reviewRepo.save(review));
    }

    @Override
    public ReviewDto updateReview(Long id, Review r) {
        var review = reviewRepo.findById(id).get();
        if(Objects.nonNull(r.getComment())){
            review.setComment(r.getComment());
        }
        return (ReviewDto) mapper.toDto(review);
    }

    @Override
    public void deleteReviewById(Long id) {
        reviewRepo.deleteById(id);
    }
}
