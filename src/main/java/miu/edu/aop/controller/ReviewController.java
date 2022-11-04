package miu.edu.aop.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.aop.annotation.ExecutionTime;
import miu.edu.aop.dto.ReviewDTO;
import miu.edu.aop.service.ReviewServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewServiceImpl service;

    @GetMapping()
    @ExecutionTime
    public List<ReviewDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> get(@PathVariable Long id) {
        return service.findOne(id).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ReviewDTO create(@RequestBody ReviewDTO review) {
        return service.save(review);
    }

    @PutMapping("/{id}")
    public ReviewDTO update(@PathVariable Long id, @RequestBody ReviewDTO review) {
        review.setId(id);
        return service.save(review);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}