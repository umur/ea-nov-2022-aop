package com.example.Product.Review.controller;

import com.example.Product.Review.entities.join_column.Category;
import com.example.Product.Review.entities.join_column.Product;
import com.example.Product.Review.service.impl.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable long id) {
        return productService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody Product product) {
        productService.save(product);
    }

    @PutMapping
    public void update(@RequestBody Product product) {
        productService.update(product);
    }

    @DeleteMapping
    public void delete(@RequestBody Product product) {
        productService.delete(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        productService.deleteById(id);
    }

    @GetMapping("/filter_greater_than")
    public List<Product> findByPriceGreater(@RequestParam double price) {
        return productService.findByPriceGreater(price);
    }

    @GetMapping("/filter")
    public List<Product> findProductsByPriceLessThanAndCategory(@RequestBody Category cat, @RequestParam double price){
        return productService.findProductsByPriceLessThanAndCategory(cat, price);
    }

    @GetMapping("/filter_keyword")
    public List<Product> findProductsByNameContainingIgnoreCase(String keyword) {
        return productService.findProductsByNameContainingIgnoreCase(keyword);
    }
}
