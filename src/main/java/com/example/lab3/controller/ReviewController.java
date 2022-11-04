package com.example.lab3.controller;

import com.example.lab3.dto.ReviewDto;
import com.example.lab3.entity.bidirectional.Review;
import com.example.lab3.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/reviews")
@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @GetMapping
    public List<ReviewDto> getAll() {
        return reviewService.getAll();
    }

    @GetMapping("/{id}")
    public ReviewDto getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    @PostMapping(consumes = "application/json")
    public ReviewDto createReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    @PutMapping("/{id}")
    public ReviewDto updateReview(@PathVariable Long id, @RequestBody Review review) {
        return reviewService.updateReview(id, review);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReviewById(id);
    }
}
