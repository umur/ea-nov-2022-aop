package com.gyawalirajiv.data.services.impl;

import com.gyawalirajiv.data.models.DTOs.CategoryDTO;
import com.gyawalirajiv.data.models.Category;
import com.gyawalirajiv.data.models.DTOs.ProductDTO;
import com.gyawalirajiv.data.models.DTOs.UserDTO;
import com.gyawalirajiv.data.models.Product;
import com.gyawalirajiv.data.models.User;
import com.gyawalirajiv.data.repository.CategoryRepository;
import com.gyawalirajiv.data.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryRepository.save(modelMapper.map(categoryDTO, Category.class)), CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll().stream().map(u -> modelMapper.map(u, CategoryDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO find(Long id) {
        return modelMapper.map(categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID!")), CategoryDTO.class);
    }

    @Override
    public List<ProductDTO> findAllProductsWithCategoryAndMaxPrice(String name, Integer maxPrice) {
        List<Category> categories = categoryRepository.findAllByNameContaining(name);
        List<Product> products = categories.stream().flatMap(c -> c.getProducts().stream()).distinct().collect(Collectors.toList());
        products = products.stream().filter(p -> p.getPrice() < maxPrice).collect(Collectors.toList());
        return products.stream().map(p -> modelMapper.map(p, ProductDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        category = categoryRepository.save(category);
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public CategoryDTO delete(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID!"));
        categoryRepository.delete(category);
        return modelMapper.map(category, CategoryDTO.class);
    }
}
