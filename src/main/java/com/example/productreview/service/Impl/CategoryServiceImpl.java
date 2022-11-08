package com.example.productreview.service.Impl;

import com.example.productreview.entity.uni_and_bi_directional.Category;
import com.example.productreview.repository.CategoryRepo;
import com.example.productreview.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepo.findById(id).get();
    }

    @Override
    public void add(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public void update(Long id, Category category) {
        Category oldCategory = categoryRepo.findById(id).get();
        oldCategory.setName(category.getName());
        categoryRepo.save(oldCategory);
    }

    @Override
    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }
}
