package com.example.eanov2022springdataI.controller;

import com.example.eanov2022springdataI.entity.Category;
import com.example.eanov2022springdataI.entity.Product;
import com.example.eanov2022springdataI.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController extends CrudController<Product, ProductService>{

    public ProductController(ProductService service) {
        super(service);
    }


    @GetMapping("/min-price")
    public List<Product> getByMinPrice(@RequestParam Double price) {
        return service.findAllWithMinPrice(price);
    }

    @GetMapping("/category-and-max-price")
    public List<Product> getByCategoryAndMaxPrice(@RequestParam String category_id, @RequestParam Double price) {
        return service.findAllWithCategoryIdAndMaxPrice(category_id, price);
    }

    @GetMapping("/keyword/{keyword}")
    public List<Product> getByName(@PathVariable String keyword) {
        return service.findAllWithNameContains(keyword);
    }
}
