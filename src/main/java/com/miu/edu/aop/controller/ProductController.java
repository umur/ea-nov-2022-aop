package com.miu.edu.aop.controller;

import com.miu.edu.aop.dto.ProductDto;
import com.miu.edu.aop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProduct() {
        return productService.getAllProducts();
    }

    @GetMapping("/search")
    public List<ProductDto> getProductByName(@RequestParam String name) {
        return productService.searchProductsByName(name);
    }

    @GetMapping("/filter")
    public List<ProductDto> findProductsByPriceGreaterThanEqualAndNameContaining(@RequestParam(value = "min-price", defaultValue = "0") Double minPrice,
                                                                @RequestParam(value = "name", required = false, defaultValue = "") String name) {
        if (!name.isBlank()) {
            return productService.findProductByPriceGreaterThanEqualAndNameContainingIgnoreCase(minPrice, name);
        }
        return productService.findProductsByPriceGreaterThanEqual(minPrice);
    }

    @GetMapping("/category/{id}")
    public List<ProductDto> getAllProductByCategoryId(@PathVariable int id, @RequestParam(value = "max-price", required = false, defaultValue = "0") Double maxPrice) {
        if (maxPrice > 0) {
            return productService.findProductsByCategoryIdAndPriceLessThanEqual(id, maxPrice);
        }
        return productService.getAllProductsByCategoryId(id);
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody ProductDto product) {
        productService.updateProduct(id, product);
    }

    @PostMapping
    public ProductDto addProduct(@RequestBody ProductDto product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable int id) {
        productService.removeById(id);
    }
}
