package com.aop.springaop.springdatabidirectional.service;


import com.aop.springaop.springdatabidirectional.entity.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);
    Category updateCategory(Category category);
    Category getById(Long id);
    void deleteCategory(Long id);
    List<Category> getAll();
}
