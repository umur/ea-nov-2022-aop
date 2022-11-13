package com.example.EA.Lab3.Service;

import com.example.EA.Lab3.DTO.CategoryDTO;

import java.util.List;

public interface CategoryService {
     List<CategoryDTO> findAll();
     CategoryDTO save(CategoryDTO category);
     CategoryDTO update(Long id, CategoryDTO category);
     void delete(Long id);
}
