package com.example.EA.Lab3.Controller;

import com.example.EA.Lab3.DTO.ReviewDTO;
import com.example.EA.Lab3.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDTO> findAll(){
        return reviewService.findAll();
    }
    @PostMapping
    public ReviewDTO save(@RequestBody ReviewDTO review){
        return reviewService.save(review);
    }
    @PutMapping("/{id}")
    public ReviewDTO update(@PathVariable Long id, @RequestBody ReviewDTO review){
        return reviewService.update(id, review);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        reviewService.delete(id);
    }

}
