package com.example.productreview.service;

import com.example.productreview.entity.DTO.ReviewDTO;
import com.example.productreview.entity.uni_and_bi_directional.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll();
    Review findById(Long id);
    void add(Review user);
    void update(Long id, Review review);
    void delete(Long id);
    List<ReviewDTO> findAllByProductId(Long id);
}
