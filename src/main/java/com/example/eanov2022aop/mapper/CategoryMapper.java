package com.example.eanov2022aop.mapper;


import com.example.eanov2022aop.dto.CategoryDto;
import com.example.eanov2022aop.entity.Category;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryMapper {
    private final ModelMapper modelMapper;

    public CategoryDto toDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }

    public List <CategoryDto> toDtos(List<Category> categories) {
        return categories.stream()
                .map(this::toDto)
                .toList();
    }

    public Category toEntity(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }

    public List<Category> toEntities(List<CategoryDto> categoryDtos) {
        return categoryDtos.stream()
                .map(this::toEntity)
                .toList();
    }
}
