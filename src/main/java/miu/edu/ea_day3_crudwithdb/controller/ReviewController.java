package miu.edu.ea_day3_crudwithdb.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.ea_day3_crudwithdb.DTO.CategoryDto;
import miu.edu.ea_day3_crudwithdb.DTO.ReviewDto;
import miu.edu.ea_day3_crudwithdb.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public void save(@RequestBody ReviewDto review) {
        reviewService.save(review);
    }

    @GetMapping
    public List<ReviewDto> getAll() {
        return reviewService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> getById(@PathVariable int id) {
        var review = reviewService.getById(id);
        return ResponseEntity.ok(review);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        reviewService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody ReviewDto review) {
        reviewService.update(id, review);
    }
}
