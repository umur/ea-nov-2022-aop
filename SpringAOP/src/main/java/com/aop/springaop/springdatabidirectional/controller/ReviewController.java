package com.aop.springaop.springdatabidirectional.controller;


import com.aop.springaop.aspectAdvice.ExecutionTime;
import com.aop.springaop.springdatabidirectional.entity.Review;
import com.aop.springaop.springdatabidirectional.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @ExecutionTime
    @GetMapping
    public List<Review> getReview(){
        return reviewService.getAll();
    }
    @ExecutionTime
    @PostMapping("/save")
    public Review saveAddress(@RequestBody Review review){
        return reviewService.save(review);
    }
    @ExecutionTime
    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id){
        return reviewService.getById(id);
    }
    @ExecutionTime
    @DeleteMapping("/delete/{id}")
    public void deleteReviewById(@PathVariable Long id){
        reviewService.deleteReview(id);
    }
    @ExecutionTime
    @GetMapping("/filter")
    public List<Review> findReviewsByIdIs(@RequestParam Long id) {
        return reviewService.findReviewByIdIs(id);
    }
}
