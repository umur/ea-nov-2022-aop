package com.example.productreview.service;

import com.example.productreview.entity.uni_and_bi_directional.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Long id);
    void add(Category category);
    void update(Long id, Category category);
    void delete(Long id);
}
