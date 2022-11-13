package com.example.EA.Lab3.Service.Impl;

import com.example.EA.Lab3.DTO.CategoryDTO;
import com.example.EA.Lab3.Entity.Category;
import com.example.EA.Lab3.Repo.CategoryRepo;
import com.example.EA.Lab3.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;
    @Override
    public List<CategoryDTO> findAll() {
        List<CategoryDTO> mappedCategories = new ArrayList<>();
        categoryRepo.findAll()
                .forEach(category -> mappedCategories.add(modelMapper.map(category, CategoryDTO.class)));
        return mappedCategories;
    }
    @Override
    public CategoryDTO save(CategoryDTO category){
        Category mappedCategory = modelMapper.map(category, Category.class);
        return modelMapper.map(categoryRepo.save(mappedCategory), CategoryDTO.class);
    }
    @Override
    public CategoryDTO update(Long id, CategoryDTO category){
        Category mappedCategory = modelMapper.map(category, Category.class);
        return modelMapper.map(categoryRepo.save(mappedCategory), CategoryDTO.class);
    }
    @Override
    public void delete(Long id){
        Category category = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID !"));
        categoryRepo.delete(category);
        //modelMapper.map(category, CategoryDTO.class);
    }


}
