package com.example.productreviewapplication.service.impl;

import com.example.productreviewapplication.aspect.annotation.ExecutionTime;
import com.example.productreviewapplication.model.Product;
import com.example.productreviewapplication.repository.ProductRepository;
import com.example.productreviewapplication.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    public ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product updateProductPrice(Integer id, Double price) {
        Product product = productRepository.findById(id).orElse(null);
        if(product != null){
            product.setPrice(price);
        }
        return product;
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    @ExecutionTime
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    @ExecutionTime
    public List<Product> findProductsByPriceGreaterThan(Double minPrice) {
        return productRepository.findProductsByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> findProductsByPriceLessThanAndCategory_Name(Double maxPrice, String name) {
        return productRepository.findProductsByPriceLessThanAndCategoryName(maxPrice, name);
    }

    @Override
    public List<Product> findProductsByNameContainingIgnoreCase(String keyword) {
        return productRepository.findProductsByNameContainingIgnoreCase(keyword);
    }
}
