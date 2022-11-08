package com.example.productreview.service.Impl;

import com.example.productreview.entity.DTO.DTOConverter;
import com.example.productreview.entity.DTO.ReviewDTO;
import com.example.productreview.entity.uni_and_bi_directional.Review;
import com.example.productreview.repository.ReviewRepo;
import com.example.productreview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceimpl implements ReviewService {

    @Autowired
    ReviewRepo reviewRepo;

    @Override
    public List<Review> findAll() {
        return reviewRepo.findAll();
    }

    @Override
    public Review findById(Long id) {
        return reviewRepo.findById(id).get();
    }

    @Override
    public void add(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public void update(Long id, Review review) {
        Review oldR = reviewRepo.findById(id).get();
        oldR.setComment(review.getComment());
        reviewRepo.save(oldR);
    }

    @Override
    public void delete(Long id) {
        reviewRepo.deleteById(id);
    }

    @Override
    public List<ReviewDTO> findAllByProductId(Long id) {
        DTOConverter dtoConverter = new DTOConverter();
        return reviewRepo.findAllByProductId(id).stream()
                .map(review -> dtoConverter.reviewToDTO(review))
                .toList();
    }
}
