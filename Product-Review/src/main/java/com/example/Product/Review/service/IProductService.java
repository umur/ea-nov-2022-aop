package com.example.Product.Review.service;

import com.example.Product.Review.entities.join_column.Category;
import com.example.Product.Review.entities.join_column.Product;

import javax.sound.sampled.Port;
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
