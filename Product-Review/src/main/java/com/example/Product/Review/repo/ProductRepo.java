package com.example.Product.Review.repo;

import com.example.Product.Review.entities.join_column.Category;
import com.example.Product.Review.entities.join_column.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {

    List<Product> findProductsByPriceGreaterThan(double price);

    List<Product> findProductsByPriceLessThanAndCategory(Category cat, double price);

    List<Product> findProductsByNameContainingIgnoreCase(String keyword);

}
