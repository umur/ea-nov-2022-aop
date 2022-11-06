package com.example.productreviewapplication.controller;

import com.example.productreviewapplication.model.Review;
import com.example.productreviewapplication.service.AddressService;
import com.example.productreviewapplication.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewController {

    public ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public void addReview(@RequestBody Review review){
        reviewService.addReview(review);
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Integer id, String comment){
        reviewService.updateReview(id, comment);
        return reviewService.getReviewById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Integer id){
        reviewService.deleteReview(id);
    }
    @GetMapping
    public Iterable<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Integer id){
        return reviewService.getReviewById(id);
    }

    @GetMapping("/product/{id}")
    public List<Review> findReviewsByProductId(@PathVariable Integer id){
        return reviewService.findReviewsByProductId(id);
    }

}
