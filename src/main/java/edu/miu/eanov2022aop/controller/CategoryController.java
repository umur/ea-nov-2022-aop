package edu.miu.eanov2022aop.controller;

import edu.miu.eanov2022aop.model.Category;
import edu.miu.eanov2022aop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.add(category), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Category category) {
        return new ResponseEntity<>(categoryService.updateById(id, category), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
        return new ResponseEntity<>("Deleted Successfully !!", HttpStatus.OK);
    }
}
