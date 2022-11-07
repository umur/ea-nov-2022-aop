package com.example.Product.Review.service;

import com.example.Product.Review.entities.join_column.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();
    Category findById(long id);
    void save(Category category);
    void update(Category category);
    void deleteById(long id);
    void delete(Category category);
}
