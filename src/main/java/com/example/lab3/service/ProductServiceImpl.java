package com.example.lab3.service;

import com.example.lab3.aspect.annotation.ExecutionTime;
import com.example.lab3.model.Product;
import com.example.lab3.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product getById(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    @ExecutionTime
    public List<Product> getAllProducts() {
        return (List<Product>) productRepo.findAll();
    }
    @Override
    public List<Product> findProductByPriceGreaterThan(double minPrice){
        return productRepo.findProductByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> findProductByCategoryNameAndPriceLessThan(String category, double price) {
        return productRepo.findProductByCategoryNameAndPriceLessThan(category, price);
    }

    @Override
    public List<Product> findAllByNameContaining(String nameFilter){
        return productRepo.findAllByNameContaining(nameFilter);
    }

    @Override
    public void addProduct(Product product) {
        productRepo.save(product);
    }
}
