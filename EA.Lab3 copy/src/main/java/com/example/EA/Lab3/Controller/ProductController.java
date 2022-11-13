package com.example.EA.Lab3.Controller;

import com.example.EA.Lab3.DTO.ProductDTO;
import com.example.EA.Lab3.DTO.ReviewDTO;
import com.example.EA.Lab3.Entity.Category;
import com.example.EA.Lab3.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> findAll(){
        return productService.findAll();
    }
    @PostMapping
    public ProductDTO save(@RequestBody ProductDTO product){
        return productService.save(product);
    }
    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable Long id, @RequestBody ProductDTO product){
        return productService.update(id, product);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        productService.delete(id);
    }

    @GetMapping("/filterMoreThan/{minPrice}")
    public List<ProductDTO> findMoreThanMinPrice(@RequestParam Long minPrice){
        return productService.findMoreThanMinPrice(minPrice);
    }
    @GetMapping("/filterCategory/filterLessThan/{maxPrice}")
    public List<ProductDTO> findLessThanMaxPrice(@RequestBody Category category, @RequestParam Long maxPrice){
        return productService.findCategoryAndLessThanMaxPrice(category, maxPrice);
    }
    @GetMapping("/filterByName")
    public List<ProductDTO> findContainsKeyword(@RequestParam String keyword){
        return productService.findContainsKeyword(keyword);
    }
    @GetMapping("/{id}/reviews")
    public List<ReviewDTO> findReviewsOfProduct(@PathVariable Long id){
        return productService.findReviewsOfProduct(id);
    }
}
