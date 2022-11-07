package com.example.eanov2022aop.service;

import com.example.eanov2022aop.entity.Product;
import com.example.eanov2022aop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends CrudService<Product, ProductRepository>{

    public ProductService(ProductRepository repository) {
        super(repository);
    }

    public List<Product> findAllWithMinPrice(Double price) {
        return repository.findAllByPriceGreaterThanEqual(price)
                .stream()
                .toList();
    }

    public List<Product> findAllWithCategoryIdAndMaxPrice(String category_id, Double price) {
        return repository.findAllByCategoryIdAndPriceLessThanEqual(category_id, price)
                .stream()
                .toList();
    }

    public List<Product> findAllWithNameContains(String term) {
        return repository.findAllByNameContains(term)
                .stream()
                .toList();
    }
}
