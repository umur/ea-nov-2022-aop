package com.example.lab3springdata.service;

import com.example.lab3springdata.model.uni_directional.Product;
import com.example.lab3springdata.model.uni_directional.Review;

import java.util.List;

public interface ProductService {

    public List<Product> getAll();
    public Product getProductById(int id);
    public void create(Product product);
    public Product update(int id, Product product);
    public void delete(int id);

    List<Product> findAllByPriceGreaterThan(double price);

    List<Product> findAllByCategory_NameAndPriceIsLessThan(String name, double price);

    List<Product> findAllByNameContaining(String name);
}
