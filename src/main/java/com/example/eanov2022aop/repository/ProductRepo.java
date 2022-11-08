package com.example.eanov2022aop.repository;

import com.example.eanov2022aop.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product,Integer> {
    @Query("SELECT p FROM Product p WHERE p.id = ?1")
    Product findProductById(Integer id);

    List<Product> findProductsByPriceGreaterThanEqual(double minPrice);

    List<Product> findByCategory_IdAndPriceLessThanEqual(Integer id, double maxPrice);

    List<Product> findProductsByNameContains(String keyword);
}
