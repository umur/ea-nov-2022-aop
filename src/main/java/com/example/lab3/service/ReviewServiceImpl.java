package com.example.lab3.service;

import com.example.lab3.model.Review;
import com.example.lab3.repository.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;

    public List<Review> getReviews(Long id) {
        return reviewRepo.getReviews(id);
    }
}
