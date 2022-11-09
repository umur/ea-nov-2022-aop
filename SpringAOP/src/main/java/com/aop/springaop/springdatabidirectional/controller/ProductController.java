package com.aop.springaop.springdatabidirectional.controller;

import com.aop.springaop.aspectAdvice.ExecutionTime;
import com.aop.springaop.springdatabidirectional.entity.Product;
import com.aop.springaop.springdatabidirectional.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @ExecutionTime
    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product) {
        return productService.save(product);
    }
    @ExecutionTime
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    @ExecutionTime
    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
    @GetMapping("/minPrice")
    public List<Product> findProductsByPriceIsGreaterThan(@RequestParam double minPrice) {
        return productService.findProductsByPriceIsLessThan(minPrice);
    }
    @ExecutionTime
    @GetMapping("/maxPrice")
    public List<Product> findProductsByNameIsLessThan(@RequestParam double maxPrice) {
        return productService.findProductsByPriceIsLessThan(maxPrice);
    }
    @GetMapping("/name")
    public List<Product> findProductsByNameIsLikeIgnoreCase(@RequestParam String name) {
        return productService.findProductsByNameIsLikeIgnoreCase(name);
    }
    @GetMapping("/review")
    public List<Product> findProductsByReviewsAndIdContaining(@RequestParam Long id) {
        return productService.findProductsByReviewsAndIdContaining(id);
    }
}
