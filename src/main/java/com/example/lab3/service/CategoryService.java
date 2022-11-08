package com.example.lab3.service;

import com.example.lab3.dto.CategoryDto;
import com.example.lab3.entity.bidirectional.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAll();
    CategoryDto getCategoryById(Long id);
    CategoryDto saveCategory(Category category);
    CategoryDto updateCategory(Long id, Category category);
    void deleteCategoryById(Long id);
}
