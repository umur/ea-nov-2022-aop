package com.example.EA.Lab3.Service;

import com.example.EA.Lab3.DTO.ProductDTO;
import com.example.EA.Lab3.DTO.ReviewDTO;
import com.example.EA.Lab3.Entity.Category;

import java.util.List;

public interface ProductService {
     List<ProductDTO> findAll();
     ProductDTO save(ProductDTO product);
     ProductDTO update(Long id, ProductDTO product);
     void delete(Long id);
     List<ProductDTO> findMoreThanMinPrice(Long minPrice);
     List<ProductDTO> findCategoryAndLessThanMaxPrice(Category category, Long maxPrice);
     List<ProductDTO> findContainsKeyword(String keyword);
     List<ReviewDTO> findReviewsOfProduct(Long id);
}
