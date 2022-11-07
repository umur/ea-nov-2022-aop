package com.example.Product.Review.service.impl;

import com.example.Product.Review.entities.join_column.Category;
import com.example.Product.Review.entities.join_column.Product;
import com.example.Product.Review.repo.ProductRepo;
import com.example.Product.Review.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepo.findAll();
    }

    @Override
    public Product findById(long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void update(Product product) {
        productRepo.save(product);
    }

    @Override
    public void deleteById(long id) {
        productRepo.deleteById(id);
    }

    @Override
    public void delete(Product product) {
        productRepo.delete(product);
    }

    @Override
    public List<Product> findByPriceGreater(double price) {
        return productRepo.findProductsByPriceGreaterThan(price);
    }

    @Override
    public List<Product> findProductsByPriceLessThanAndCategory(Category cat, double price) {
        return null;
    }

    @Override
    public List<Product> findProductsByNameContainingIgnoreCase(String keyword) {
        return productRepo.findProductsByNameContainingIgnoreCase(keyword);
    }
}
