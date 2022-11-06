package com.example.lab3springdata.controller;

import com.example.lab3springdata.model.dto.ReviewDTO;
import com.example.lab3springdata.service.IProductService;
import com.example.lab3springdata.service.IReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@SuppressWarnings("unused")
public class ReviewController {
    private final IReviewService reviewService;

    public ReviewController(IReviewService reviewService, IProductService productService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/filter") // localhost/reviews/filter?productId=1
    public List<ReviewDTO> getProductsByNameContaining(@RequestParam int productId){
        return reviewService.getReviewsByProduct(productId);
    }
}
