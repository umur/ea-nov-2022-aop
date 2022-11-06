package com.example.productreviewapplication.service.impl;

import com.example.productreviewapplication.model.Category;
import com.example.productreviewapplication.repository.CategoryRepository;
import com.example.productreviewapplication.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    public CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category updateCategoryName(Integer id, String name) {
        Category category = categoryRepository.findById(id).get();
        if(category != null){
            category.setName(name);
        }
        return category;
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Iterable<Category> getAllAddresses() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
