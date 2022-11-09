package com.aop.springaop.springdatabidirectional.service.Impl;

import com.aop.springaop.springdatabidirectional.entity.Category;
import com.aop.springaop.springdatabidirectional.repository.CategoryRepository;
import com.aop.springaop.springdatabidirectional.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return null;
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getAll() {
        List<Category> categoryList=new ArrayList<>();
        categoryRepository.findAll().forEach(categoryList::add);
        return categoryList;
    }
}
