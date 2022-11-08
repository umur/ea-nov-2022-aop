package com.example.productreview.controller;

import com.example.productreview.entity.DTO.ProductDTO;
import com.example.productreview.entity.uni_and_bi_directional.Product;
import com.example.productreview.service.CategoryService;
import com.example.productreview.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping
    List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/greater/{price}")
    List<Product> findAllGreaterThan(@PathVariable double price){
        return productService.findAllByPriceGreaterThan(price);
    }

    @GetMapping("/greaterjpql/{price}")
    List<ProductDTO> findAllGreaterThanJPQL(@PathVariable double price){
        return productService.findAllByPriceGreaterThanJPQL(price);
    }

    @GetMapping("/filterjpql")
    List<ProductDTO> findAllByNameJPQL(@RequestParam String name){
        return productService.findAllByNameContainingJPQL(name);
    }

    @GetMapping("/filter")
    List<Product> findAllByName(@RequestParam String name){
        return productService.findAllByNameContaining(name);
    }

    @GetMapping("/filter-cat-price")
    List<ProductDTO> findAllByName(@RequestParam Long category, @RequestParam double price ){
        return productService.findAllByCategoryEqualsAndPriceLessThan(categoryService.findById(category), price);
    }

    @PostMapping
    String addNew(@RequestBody Product product){
        productService.add(product);
        return "Product Saved!!!";
    }

    @PutMapping("/{id}")
    String update(@PathVariable Long id, @RequestBody Product product){
        Product oldProduct;
        try {
            oldProduct = productService.findById(id);
        }catch (Exception ex){
            return "Error -> " + ex.toString();
        }

        oldProduct.setRating(product.getRating());
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());

        productService.add(oldProduct);

        return "Product updated!!!";
    }

    @DeleteMapping("/delete")
    String delete(@RequestParam Long id){
        try {
            productService.delete(id);
        }catch (Exception ex){
            return "Error -> " + ex.toString();
        }
        return "Product deleted!!!";
    }

}
