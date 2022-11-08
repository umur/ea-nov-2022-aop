package com.example.eanov2022aop.controller;


import com.example.eanov2022aop.dto.ProductDto;
import com.example.eanov2022aop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productsService;

    @GetMapping
    public List <ProductDto> getProducts(){
        return productsService.findAll ();
    }

    @GetMapping(path = "/{id}")
    public ProductDto getProductsById(@PathVariable("id") Integer id){
        return productsService.findProductById (id);
    }
    @GetMapping(path = "/search")
    public List<ProductDto> find(@RequestParam("minPrice") double minPrice){
        return productsService.findProductsByPrice(minPrice);
    }

    @GetMapping(path = "/search name")
    public List<ProductDto> find(@RequestParam("keyword") String keyword){
        return productsService.findProductsByNameContains (keyword);
    }

    @GetMapping(path = "/category/{id}/search")
    public List<ProductDto> find(@PathVariable("id") Integer id,
                              @RequestParam("maxPrice") double maxPrice){
        return productsService.findByCategory_IdAndPrice (id,maxPrice);
    }

    @PostMapping
    public void create(@RequestBody ProductDto productDto){
        productsService.create (productDto);
    }

    @PutMapping(path = "/{id}")
    public void update(@PathVariable("id") Integer id,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) Integer price){
        productsService.update (id,name,price);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Integer id){
        productsService.delete(id);

    }
}
