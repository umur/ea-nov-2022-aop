package com.aop.springaop.springdatabidirectional.controller;

import com.aop.springaop.aspectAdvice.ExecutionTime;
import com.aop.springaop.springdatabidirectional.entity.Category;
import com.aop.springaop.springdatabidirectional.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ExecutionTime
    @GetMapping
    public List<Category> getAddress(){
        return categoryService.getAll();
    }
    @ExecutionTime
    @PostMapping("/save")
    public Category saveAddress(@RequestBody Category category){
        return categoryService.save(category);
    }
    @ExecutionTime
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return categoryService.getById(id);
    }
    @ExecutionTime
    @DeleteMapping("/delete/{id}")
    public void deleteAddressById(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
