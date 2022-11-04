package com.example.eanov2022springdataI.service;

import com.example.eanov2022springdataI.entity.Category;
import com.example.eanov2022springdataI.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends CrudService<Category, CategoryRepository>{

    public CategoryService(CategoryRepository repository) {
        super(repository);
    }
}
