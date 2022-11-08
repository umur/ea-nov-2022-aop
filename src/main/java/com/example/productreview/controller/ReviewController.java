package com.example.productreview.controller;

import com.example.productreview.entity.DTO.ReviewDTO;
import com.example.productreview.entity.uni_and_bi_directional.Review;
import com.example.productreview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @GetMapping
    List<Review> findAll(){
        return reviewService.findAll();
    }

    @GetMapping("/filter")
    List<ReviewDTO> findAllByProductId(@RequestParam Long productId){
        return reviewService.findAllByProductId(productId);
    }

    @PostMapping
    String addNew(@RequestBody Review review){
        reviewService.add(review);
        return "Category Saved!!!";
    }

    @PutMapping("/{id}")
    String update(@PathVariable Long id, @RequestBody Review review){
        Review oldR;
        try {
            oldR = reviewService.findById(id);
        }catch (Exception ex){
            return "Error -> " + ex.toString();
        }

        oldR.setComment(review.getComment());

        reviewService.add(oldR);

        return "Review updated!!!";
    }

    @DeleteMapping("/delete")
    String delete(@RequestParam Long id){
        try {
            reviewService.delete(id);
        }catch (Exception ex){
            return "Error -> " + ex.toString();
        }
        return "Review deleted!!!";
    }
}
