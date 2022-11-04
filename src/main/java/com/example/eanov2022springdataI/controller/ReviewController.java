package com.example.eanov2022springdataI.controller;

import com.example.eanov2022springdataI.entity.Review;
import com.example.eanov2022springdataI.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/reviews")
public class ReviewController extends CrudController<Review, ReviewService>{

    public ReviewController(ReviewService service) {
        super(service);
    }

    @GetMapping("/product/{id}")
    public List<Review> getReviewsOfProduct(@PathVariable String id) {
        return service.findAllReviewByProductId(id);
    }
}
