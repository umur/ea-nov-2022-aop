package com.example.productreviewapplication.service;

import com.example.productreviewapplication.model.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    public void addCategory(Category category);
    public Category updateCategoryName(Integer id, String categoryName);
    public void deleteCategory(Integer id);
    public Iterable<Category> getAllAddresses();
    public Category getCategoryById(Integer id);
}
