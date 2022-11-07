package com.example.Product.Review.controller;

import com.example.Product.Review.entities.join_column.Category;
import com.example.Product.Review.service.impl.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable long id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody Category category) {
        categoryService.save(category);
    }

    @PutMapping
    public void update(@RequestBody Category category) {
        categoryService.save(category);
    }

    @DeleteMapping
    public void delete(@RequestBody Category category) {
        categoryService.delete(category);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        categoryService.deleteById(id);
    }


}
