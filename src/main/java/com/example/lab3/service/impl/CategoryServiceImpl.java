package com.example.lab3.service.impl;

import com.example.lab3.dto.AddressDto;
import com.example.lab3.dto.CategoryDto;
import com.example.lab3.entity.bidirectional.Address;
import com.example.lab3.entity.bidirectional.Category;
import com.example.lab3.mapper.Mapper;
import com.example.lab3.repository.CategoryRepo;
import com.example.lab3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    private Mapper mapper = new Mapper<Category, CategoryDto>(Category.class, CategoryDto.class);

    @Override
    public List<CategoryDto> getAll() {
        return mapper.toListDto((List<Category>) categoryRepo.findAll());
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        return (CategoryDto) mapper.toDto(categoryRepo.findById(id).get());
    }

    @Override
    public CategoryDto saveCategory(Category category) {
        return (CategoryDto) mapper.toDto(categoryRepo.save(category));
    }

    @Override
    public CategoryDto updateCategory(Long id, Category c) {
        Category category = categoryRepo.findById(id).get();
        if (Objects.nonNull(c.getName())) {
            category.setName(c.getName());
        }
        if (Objects.nonNull(c.getProducts())) {
            category.setProducts(c.getProducts());
        }
        return (CategoryDto) mapper.toDto(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepo.deleteById(id);
    }
}
