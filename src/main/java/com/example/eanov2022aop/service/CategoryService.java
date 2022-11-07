package com.example.eanov2022aop.service;

import com.example.eanov2022aop.entity.Category;
import com.example.eanov2022aop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends CrudService<Category, CategoryRepository>{

    public CategoryService(CategoryRepository repository) {
        super(repository);
    }
}
