package com.miu.edu.aop.repository;

import com.miu.edu.aop.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findAll();

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> getProductsByCategoryId(int categoryId);

    List<Product> findProductsByPriceGreaterThanEqual(Double minPrice);

    List<Product> findProductsByCategory_IdAndPriceLessThanEqual(int id, Double maxPrice);

    List<Product> findProductByPriceGreaterThanEqualAndNameContainingIgnoreCase(Double price, String name);

}
