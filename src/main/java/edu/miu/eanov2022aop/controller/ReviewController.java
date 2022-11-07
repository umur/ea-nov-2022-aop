package edu.miu.eanov2022aop.controller;

import edu.miu.eanov2022aop.model.Review;
import edu.miu.eanov2022aop.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(reviewService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(reviewService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Review review) {
        return new ResponseEntity<>(reviewService.add(review), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Review review) {
        return new ResponseEntity<>(reviewService.updateById(id, review), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        reviewService.deleteById(id);
        return new ResponseEntity<>("Deleted Successfully !!", HttpStatus.OK);
    }
}
