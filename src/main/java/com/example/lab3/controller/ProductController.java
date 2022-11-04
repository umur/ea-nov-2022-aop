package com.example.lab3.controller;

import com.example.lab3.dto.ProductDto;
import com.example.lab3.dto.ReviewDto;
import com.example.lab3.entity.bidirectional.Product;
import com.example.lab3.entity.bidirectional.Review;
import com.example.lab3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public List<ProductDto> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/price")
    public List<ProductDto> getProductsMinPrice(@RequestParam(name="min-price") Long minPrice){
        return productService.getProductsMinPrice(minPrice);
    }

    @GetMapping("/categories/{categoryName}")
    public List<ProductDto> getProductsInCategoryWithMaxPrice(@PathVariable String categoryName, @RequestParam(name = "max-price") Long maxPrice){
        return productService.getProductsInCategoryWithMaxPrice(categoryName, maxPrice);
    }

    @GetMapping("/search")
    public List<ProductDto> searchProducts(@RequestParam(name="keyword") String keyword){
        return productService.searchProductsByName(keyword);
    }

    @GetMapping("/{id}/reviews")
    public List<ReviewDto> getProductReviews(@PathVariable Long id){
        return productService.getProductReviews(id);
    }
}
