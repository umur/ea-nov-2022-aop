package com.example.productreview.service;

import com.example.productreview.entity.DTO.ProductDTO;
import com.example.productreview.entity.uni_and_bi_directional.Category;
import com.example.productreview.entity.uni_and_bi_directional.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    void add(Product user);
    void update(Long id, Product user);
    void delete(Long id);
    List<Product> findAllByPriceGreaterThan(double price);
    List<Product> findAllByNameContaining(String keyword);
    List<ProductDTO> findAllByPriceGreaterThanJPQL(double price);
    List<ProductDTO> findAllByNameContainingJPQL(String keyword);
    List<ProductDTO> findAllByCategoryEqualsAndPriceLessThan(Category category, double price);
}
