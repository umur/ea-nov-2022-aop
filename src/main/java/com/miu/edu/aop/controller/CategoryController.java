package com.miu.edu.aop.controller;

import com.miu.edu.aop.dto.CategoryDto;
import com.miu.edu.aop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    @PutMapping
    public void updateCategory(@RequestBody CategoryDto student) {
        categoryService.updateCategory(student);
    }

    @PostMapping
    public void addCategory(@RequestBody CategoryDto student) {
        categoryService.addCategory(student);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable int id) {
        categoryService.removeById(id);
    }
}
