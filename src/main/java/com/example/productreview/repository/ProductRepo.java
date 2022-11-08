package com.example.productreview.repository;

import com.example.productreview.entity.uni_and_bi_directional.Category;
import com.example.productreview.entity.uni_and_bi_directional.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
    List<Product> findAll();
    List<Product> findAllByPriceGreaterThan(double price);

    @Query("select p from Product p where p.price > ?1")
    List<Product> findAllByPriceGreaterThanJPQL(double price);
    List<Product> findAllByNameContaining(String keyword);
    @Query("select p from Product p where p.name like '%?1%'")
    List<Product> findAllByNameContainingJPQL(String keyword);
    List<Product> findAllByCategoryEqualsAndPriceLessThan(Category category, double price);
}
