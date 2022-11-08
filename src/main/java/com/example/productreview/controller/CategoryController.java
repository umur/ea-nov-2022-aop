package com.example.productreview.controller;

import com.example.productreview.entity.uni_and_bi_directional.Category;
import com.example.productreview.entity.uni_and_bi_directional.Product;
import com.example.productreview.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    List<Category> findAll(){
        return categoryService.findAll();
    }

    @PostMapping
    String addNew(@RequestBody Category category){
        categoryService.add(category);
        return "Category Saved!!!";
    }

    @PutMapping("/{id}")
    String update(@PathVariable Long id, @RequestBody Product product){
        Category oldCategory;
        try {
            oldCategory = categoryService.findById(id);
        }catch (Exception ex){
            return "Error -> " + ex.toString();
        }

        oldCategory.setName(product.getName());

        categoryService.add(oldCategory);

        return "Category updated!!!";
    }

    @DeleteMapping("/delete")
    String delete(@RequestParam Long id){
        try {
            categoryService.delete(id);
        }catch (Exception ex){
            return "Error -> " + ex.toString();
        }
        return "Category deleted!!!";
    }
}
