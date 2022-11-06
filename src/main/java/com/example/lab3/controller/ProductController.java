package com.example.lab3.controller;

import com.example.lab3.aspect.annotation.ExecutionTime;
import com.example.lab3.model.Product;
import com.example.lab3.model.Review;
import com.example.lab3.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ExecutionTime
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }

    @GetMapping("/filter") //localhost:8080/products/filter?price=100
    public List<Product> getProductsByPriceGreaterThan(@RequestParam double price){
        return productService.findProductByPriceGreaterThan(price);
    }

    @GetMapping("/category/{categoryName}/price/{price}")
    public List<Product> getProductByCategoryEqualsAndPriceLessThan(@PathVariable String categoryName,@PathVariable double price){
        return productService.findProductByCategoryNameAndPriceLessThan(categoryName, price);
    }
    @GetMapping("/search")
    public List<Product> getAllByNameContaining(@RequestParam String nameFilter){
        return productService.findAllByNameContaining(nameFilter);
    }

    @GetMapping("/{id}/reviews")
    public List<Review> getReviews(@PathVariable Long id){
        Product product = productService.getById(id);
        return (List<Review>) product.getReviews();
    }

    @PostMapping
    public void addProduct(@RequestBody Product p){
        productService.addProduct(p);
    }
}
