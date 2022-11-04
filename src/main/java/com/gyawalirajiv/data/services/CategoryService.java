package com.gyawalirajiv.data.services;

import com.gyawalirajiv.data.models.DTOs.CategoryDTO;
import com.gyawalirajiv.data.models.DTOs.ProductDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO save(CategoryDTO categoryDTO);

    List<CategoryDTO> findAll();

    CategoryDTO find(Long id);

    CategoryDTO update(Long id, CategoryDTO categoryDTO);

    CategoryDTO delete(Long id);

    List<ProductDTO> findAllProductsWithCategoryAndMaxPrice(String name, Integer maxPrice);
}
