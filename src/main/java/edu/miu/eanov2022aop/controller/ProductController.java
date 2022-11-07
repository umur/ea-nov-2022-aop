package edu.miu.eanov2022aop.controller;

import edu.miu.eanov2022aop.model.Product;
import edu.miu.eanov2022aop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Product product) {
        return new ResponseEntity<>(productService.add(product), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.updateById(id, product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return new ResponseEntity<>("Deleted Successfully !!", HttpStatus.OK);
    }
}
