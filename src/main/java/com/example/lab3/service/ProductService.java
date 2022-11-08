package com.example.lab3.service;

import com.example.lab3.dto.ProductDto;
import com.example.lab3.dto.ReviewDto;
import com.example.lab3.entity.bidirectional.Category;
import com.example.lab3.entity.bidirectional.Product;
import com.example.lab3.entity.bidirectional.Review;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAll();
    ProductDto getProductById(Long id);
    ProductDto saveProduct(Product product);
    ProductDto updateProduct(Long id, Product product);
    void deleteProduct(Long id);

    List<ProductDto> getProductsMinPrice(Long price);
    List<ProductDto> getProductsInCategoryWithMaxPrice(String categoryName, Long maxPrice);

    List<ProductDto> searchProductsByName(String keyword);

    List<ReviewDto> getProductReviews(Long id);
}
