package edu.miu.aop.aop.controller;

import edu.miu.aop.aop.dto.RequestProductDTO;
import edu.miu.aop.aop.entity.Product;
import edu.miu.aop.aop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/3/2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService service;

    @PostMapping
    public RequestProductDTO createProduct(HttpServletRequest request, @RequestBody RequestProductDTO dto) {
        return service.save(request, dto);
    }

    @PutMapping("/{id}")
    public RequestProductDTO updateProduct(@PathVariable Long id, @RequestBody RequestProductDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return service.getAllProduct();
    }

    @GetMapping("/filter")
    public List<Product> getProductByNameContains(@RequestParam String keyword) {
        return service.getAllProductByNameContain(keyword);
    }

    @GetMapping("/min-price/{min}")
    public List<Product> getAllProductPriceGreaterThan(@PathVariable Double min) {
        return service.getAllProductGreaterThanMinPrice(min);
    }

    @GetMapping("/categories/{cat}/max-price/{max}")
    public List<Product> getAllProductByCategoryAndPriceLessThan(@PathVariable String cat,
                                                                 @PathVariable Double max) {
        return service.getAllProductByCategoryAndLessThanMaxPrice(cat, max);
    }
}
