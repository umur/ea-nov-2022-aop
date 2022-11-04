package com.gyawalirajiv.data.controller;

import com.gyawalirajiv.data.models.DTOs.ProductDTO;
import com.gyawalirajiv.data.models.DTOs.ReviewDTO;
import com.gyawalirajiv.data.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductDTO save(@RequestBody ProductDTO productDTO){
        return productService.save(productDTO);
    }

    @GetMapping
    public List<ProductDTO> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDTO find(@PathVariable Long id){
        return productService.find(id);
    }

    @GetMapping("/minPrice")
    public List<ProductDTO> findProductMinPrice(@RequestParam Integer minPrice){
        return productService.findProductMinPrice(minPrice);
    }

    @GetMapping("/keyword")
    public List<ProductDTO> findProductContainingKeyword(@RequestParam String keyword){
        return productService.findProductContainingKeyword(keyword);
    }

    @GetMapping("/{id}/reviews")
    public List<ReviewDTO> findReviewsOfProduct(@PathVariable Long id){
        return productService.findReviewsOfProduct(id);
    }

    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        return productService.update(id, productDTO);
    }

    @DeleteMapping("/{id}")
    public ProductDTO delete(@PathVariable Long id){
        return productService.delete(id);
    }

}
