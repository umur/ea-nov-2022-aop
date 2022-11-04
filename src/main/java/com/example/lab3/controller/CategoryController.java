package com.example.lab3.controller;

import com.example.lab3.dto.CategoryDto;
import com.example.lab3.entity.bidirectional.Category;
import com.example.lab3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public List<CategoryDto> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping(consumes = "application/json")
    public CategoryDto createCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public CategoryDto updateCategory(@PathVariable Long id, @RequestBody Category category){
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
    }
}
