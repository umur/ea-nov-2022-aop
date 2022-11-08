package miu.edu.ea_day3_crudwithdb.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.ea_day3_crudwithdb.DTO.ProductDto;
import miu.edu.ea_day3_crudwithdb.DTO.ReviewDto;
import miu.edu.ea_day3_crudwithdb.annotation.ExecutionTime;
import miu.edu.ea_day3_crudwithdb.entity.Category;
import miu.edu.ea_day3_crudwithdb.entity.Product;
import miu.edu.ea_day3_crudwithdb.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public void save(@RequestBody ProductDto p) {
        productService.save(p);
    }

    @GetMapping
    @ExecutionTime
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @GetMapping("/getAllGreaterThan")
    public List<ProductDto> getAllGreaterThan(@RequestParam double price) {
        return productService.getProductsGreaterThanMinPrice(price);
    }

    @GetMapping("/getAllByKeyword")
    public List<ProductDto> getAllByKeyword(@RequestParam String keyword) {
        return productService.getProductsByName(keyword);
    }

    @GetMapping("/getReviewsByProductId")
    public List<ReviewDto> getAllByKeyword(@RequestParam int id) {
        return productService.getReviewByProductId(id);
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public ResponseEntity<ProductDto> getById(@PathVariable int id) {
        var product = productService.getById(id);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int productId, @RequestBody ProductDto product) {
        productService.update(productId, product);
    }

}
