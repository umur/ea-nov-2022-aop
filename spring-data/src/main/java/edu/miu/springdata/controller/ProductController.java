package edu.miu.springdata.controller;

import edu.miu.springdata.aspect.annotation.ExecutionTime;
import edu.miu.springdata.entity.Product;
import edu.miu.springdata.entity.Review;
import edu.miu.springdata.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/springdata/product")
public class ProductController {

    private final ProductService productService;

    @ExecutionTime
    @PostMapping
    public String create(@RequestBody Product product) {
        try {
            productService.save(product);

            return "Product saved successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while saving Product.";
        }
    }

    @ExecutionTime
    @PutMapping
    public String update(@RequestBody Product product) {
        try {
            productService.save(product);

            return "Product updated successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while updating Product.";
        }
    }

    @ExecutionTime
    @DeleteMapping("/{productId}")
    public String delete(@PathVariable Long productId) {
        try {
            productService.delete(productId);

            return "Product deleted successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while deleting Product.";
        }
    }

    @ExecutionTime
    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @ExecutionTime
    @GetMapping("/{productId}")
    public Product getById(@PathVariable Long productId) {
        return productService.getById(productId);
    }

    @ExecutionTime
    @GetMapping("/filterByPriceGreaterThanMinPrice")
    public List<Product> filterAllByPriceGreaterThan(@RequestParam double minPrice) {
        return productService.findAllByPriceGreaterThan(minPrice);
    }

    @ExecutionTime
    @GetMapping("/filterByNameContaining")
    public List<Product> filterAllByNameContaining(@RequestParam String name) {
        return productService.findAllByNameContaining(name);
    }

    @ExecutionTime
    @GetMapping("/filterReviewByProductId")
    public List<Review> filterReviewByProductId(@RequestParam Long productId) {
        return productService.findReviewByProductId(productId);
    }

}
