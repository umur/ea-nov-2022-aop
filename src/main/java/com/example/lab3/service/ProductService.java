package com.example.lab3.service;

import com.example.lab3.model.Product;

import java.util.List;

public interface ProductService {

    Product getById(Long id);
    List<Product> getAllProducts();

    List<Product> findProductByPriceGreaterThan(double minPrice);


    List<Product> findProductByCategoryNameAndPriceLessThan(String category, double price);

    List<Product> findAllByNameContaining(String nameFilter);

    void addProduct(Product product);
}
