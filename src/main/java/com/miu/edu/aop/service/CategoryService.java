package com.miu.edu.aop.service;

import com.miu.edu.aop.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    /**
     * Get all Categories
     * @return Categories
     */
    List<CategoryDto> getAllCategories();

    /**
     * Get Category By id
     *
     * @param id
     * @return a Category
     */
    CategoryDto getCategoryById(int id);

    /**
     * Update a Category
     * @param id
     * @param category
     */
    void updateCategory(int id, CategoryDto category);

    /**
     * Add a Category
     * @param category
     */
    CategoryDto addCategory(CategoryDto category);

    /**
     * Remove a Category by id
     * @param id
     */
    void removeById(int id);

}
