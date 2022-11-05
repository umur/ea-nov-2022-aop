package com.example.lab3springdata.controller;

import com.example.lab3springdata.aspect.annotations.ExecutionTime;
import com.example.lab3springdata.model.dto.ProductDTO;
import com.example.lab3springdata.service.IProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/filterByPrice")
    @ExecutionTime
    public List<ProductDTO> getProductsByPriceMoreThan(@RequestParam double minPrice){
        return productService.findProductsByPrice(minPrice);
    }

    @GetMapping("/filterByCategoryAndPrice")
    public List<ProductDTO> getProductsByPriceMoreThan(@RequestParam String category, @RequestParam double price){
        return productService.findProductsByCategory_NameAndPriceLessThan(category, price);
    }

    @GetMapping("/filterByName")
    public List<ProductDTO> getProductsByNameContaining(@RequestParam String name){
        return productService.findAllByNameContaining(name);
    }

    @PostMapping //(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProduct(@RequestBody ProductDTO productDTO){
        productService.addProduct(productDTO);
    }

}
