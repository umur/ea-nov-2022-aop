package com.miu.edu.aop.service.impl;

import com.miu.edu.aop.annotation.ExecutionTime;
import com.miu.edu.aop.dto.CategoryDto;
import com.miu.edu.aop.entity.Category;
import com.miu.edu.aop.repository.CategoryRepository;
import com.miu.edu.aop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    @ExecutionTime
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream().map(CategoryDto::convertFrom).toList();
    }

    @Override
    @ExecutionTime
    public CategoryDto getCategoryById(int id) {
        return CategoryDto.convertFrom(categoryRepository.findById(id).orElse(null));
    }

    @Override
    public void updateCategory(int id, CategoryDto category) {
        categoryRepository.findById(id).ifPresent(c -> {
            c.setName(category.getName());
            categoryRepository.save(c);
        });
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        return CategoryDto.convertFrom(categoryRepository.save(CategoryDto.convertTo(categoryDto)));
    }

    @Override
    public void removeById(int id) {
        categoryRepository.deleteById(id);
    }
}
