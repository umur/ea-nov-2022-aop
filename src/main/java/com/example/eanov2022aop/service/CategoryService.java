package com.example.eanov2022aop.service;



import com.example.eanov2022aop.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    public List <CategoryDto> findAll ();

    public CategoryDto findCategoryById (Integer id);

    void create (CategoryDto categoryDto);

    void delete (Integer id);

    void update(Integer id,String name);
}
