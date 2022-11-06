package com.example.productreviewapplication.controller;

import com.example.productreviewapplication.model.Category;
import com.example.productreviewapplication.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    public CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public void addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategoryName(@PathVariable Integer id, String categoryName){
        categoryService.updateCategoryName(id, categoryName);
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategory(id);
    }

    @GetMapping
    public Iterable<Category> getAllAddresses(){
        return categoryService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id){
        return categoryService.getCategoryById(id);
    }
}
