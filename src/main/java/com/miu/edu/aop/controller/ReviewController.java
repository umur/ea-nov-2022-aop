package com.miu.edu.aop.controller;

import com.miu.edu.aop.dto.ReviewDto;
import com.miu.edu.aop.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/product/{id}")
    public List<ReviewDto> getReviewByProductId(@PathVariable int id) {
        return reviewService.getReviewsByProductId(id);
    }

    @GetMapping("/{id}")
    public ReviewDto getReviewById(@PathVariable int id) {
        return reviewService.getReviewById(id);
    }

    @PutMapping("/{id}")
    public void updateReview(@PathVariable int id, @RequestBody ReviewDto review) {
        reviewService.updateReview(id, review);
    }

    @PostMapping
    public ReviewDto addReview(@RequestBody ReviewDto review) {
        return reviewService.addReview(review);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable int id) {
        reviewService.removeById(id);
    }
}
