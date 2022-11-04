package miu.edu.aop.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.aop.annotation.ExecutionTime;
import miu.edu.aop.dto.ProductDTO;
import miu.edu.aop.dto.ReviewDTO;
import miu.edu.aop.model.Category;
import miu.edu.aop.service.ProductServiceImpl;
import miu.edu.aop.service.ReviewServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl service;
    private final ReviewServiceImpl reviewService;

    @GetMapping()
    @ExecutionTime
    public List<ProductDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> get(@PathVariable Long id) {
        return service.findOne(id).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ProductDTO create(@RequestBody ProductDTO product) {
        return service.save(product);
    }

    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable Long id, @RequestBody ProductDTO product) {
        product.setId(id);
        return service.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}/reviews")
    public List<ReviewDTO> getReviewsOfProduct(@PathVariable Long id) {
        return reviewService.findAllReviewByProductId(id);
    }

    @GetMapping("min-price")
    public List<ProductDTO> getByMinPrice(@RequestParam Double price) {
        return service.findAllWithMinPrice(price);
    }

    @PostMapping("category-and-max-price")
    public List<ProductDTO> getByCategoryAndMaxPrice(@RequestBody Category category, @RequestParam Double price) {
        return service.findAllWithCategoryAndMaxPrice(category, price);
    }

    @GetMapping("keyword/{keyword}")
    public List<ProductDTO> getByName(@PathVariable String keyword) {
        return service.findAllWithNameContains(keyword);
    }
}