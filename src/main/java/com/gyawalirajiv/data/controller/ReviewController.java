package com.gyawalirajiv.data.controller;

import com.gyawalirajiv.data.models.DTOs.ReviewDTO;
import com.gyawalirajiv.data.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ReviewDTO save(@RequestBody ReviewDTO reviewDTO){
        return reviewService.save(reviewDTO);
    }

    @GetMapping
    public List<ReviewDTO> findAll(){
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewDTO find(@PathVariable Long id){
        return reviewService.find(id);
    }

    @PutMapping("/{id}")
    public ReviewDTO update(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO){
        return reviewService.update(id, reviewDTO);
    }

    @DeleteMapping("/{id}")
    public ReviewDTO delete(@PathVariable Long id){
        return reviewService.delete(id);
    }

}
