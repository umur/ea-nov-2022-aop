package com.example.Product.Review.service;

import com.example.Product.Review.entities.Category;
import com.example.Product.Review.entities.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();
    Product findById(long id);
    void save(Product product);
    void update(Product product);
    void deleteById(long id);
    void delete(Product product);

    List<Product> findByPriceGreater(double price);
    List<Product> findProductsByPriceLessThanAndCategory(Category cat, double price);

    List<Product> findProductsByNameContainingIgnoreCase(String keyword);

}
