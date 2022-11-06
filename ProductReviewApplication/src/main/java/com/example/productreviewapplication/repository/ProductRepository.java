package com.example.productreviewapplication.repository;

import com.example.productreviewapplication.model.Product;
import com.example.productreviewapplication.model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    public List<Product> findProductsByPriceGreaterThan(Double minPrice);
    public List<Product> findProductsByPriceLessThanAndCategory_Name(Double maxPrice, String name);

    public List<Product> findProductsByPriceLessThanAndCategoryName(Double minPrice, String name);
    public List<Product> findProductsByNameContainingIgnoreCase(String keyword);


}
