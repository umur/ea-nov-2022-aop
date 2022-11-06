package com.example.productreviewapplication.service;

import com.example.productreviewapplication.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public void addProduct(Product product);
    public Product updateProductPrice(Integer id, Double price);
    public void deleteProduct(Integer id);
    public Iterable<Product> getAllProducts();
    public Product getProductById(Integer id);
    public List<Product> findProductsByPriceGreaterThan(Double minPrice);
    public List<Product> findProductsByPriceLessThanAndCategory_Name(Double maxPrice, String name);
    public List<Product> findProductsByNameContainingIgnoreCase(String keyword);
}
