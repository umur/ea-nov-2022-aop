package com.example.EA.Lab3.Repo;

import com.example.EA.Lab3.Entity.Category;
import com.example.EA.Lab3.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findAllByPriceGreaterThanEqual(Long price);
    List<Product> findAllByCategoryAndPriceLessThanEqual(Category category, Long price);
    List<Product> findAllByNameContains(String keyword);
}
