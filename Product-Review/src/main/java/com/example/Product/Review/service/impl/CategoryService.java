package com.example.Product.Review.service.impl;

import com.example.Product.Review.entities.join_column.Category;
import com.example.Product.Review.repo.CategoryRepo;
import com.example.Product.Review.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepo categoryRepo;

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepo.findAll();
    }

    @Override
    public Category findById(long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public void update(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public void deleteById(long id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public void delete(Category category) {
        categoryRepo.delete(category);
    }
}
