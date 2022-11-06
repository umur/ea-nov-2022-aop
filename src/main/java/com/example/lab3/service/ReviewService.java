package com.example.lab3.service;

import com.example.lab3.model.Review;

import java.util.List;

public interface ReviewService{
    List<Review> getReviews(Long id);
}
