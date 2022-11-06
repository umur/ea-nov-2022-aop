package com.example.productreviewapplication.controller;

import com.example.productreviewapplication.model.Product;
import com.example.productreviewapplication.model.Review;
import com.example.productreviewapplication.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    public ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProductPrice(@PathVariable Integer id, Double price){
        productService.updateProductPrice(id, price);
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
    }

    @GetMapping
    public Iterable<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @GetMapping("/filter2")
    public List<Product> findProductsByPriceGreaterThan(@RequestParam Double minPrice){
        return productService.findProductsByPriceGreaterThan(minPrice);
    }
    @GetMapping("/filter3")
    public List<Product> findProductsByPriceLessThanAndCategory_Name(@RequestParam Double maxPrice, @RequestParam String name){
        return productService.findProductsByPriceLessThanAndCategory_Name(maxPrice, name);
    }

    @GetMapping("/keyword")
    public List<Product> findProductsByNameContaining(@RequestParam String keyword){
        return productService.findProductsByNameContainingIgnoreCase(keyword);
    }


}

    /*@GetMapping("/api/foos")
    @ResponseBody
    public String getFoos(@RequestParam String id) {
        return "ID: " + id;
     http://localhost:8080/spring-mvc-basics/api/foos?id=abc
----
ID: abc

http://localhost:8080/spring-mvc-basics/api/foos?id=1&id=2
----
IDs are [1,2]
    }*/