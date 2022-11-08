package com.example.lab3.repository;

import com.example.lab3.entity.bidirectional.Category;
import com.example.lab3.entity.bidirectional.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Long> {
    List<Product> findAllByPriceGreaterThan(Long price);
    List<Product> findAllByCategoryIsAndPriceLessThan(Category category, Long price);
    List<Product> findAllByNameContains(String keyword);
}
