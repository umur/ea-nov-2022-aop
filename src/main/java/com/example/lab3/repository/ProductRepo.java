package com.example.lab3.repository;

import com.example.lab3.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
//    Find all products that cost more than minPrice
    List<Product> findProductByPriceGreaterThan(double minPrice);

//    Find all products in cat category and cost less than maxPrice.
    List<Product> findProductByCategoryNameAndPriceLessThan(String category, double price);

//    Find all products that contain keyword in the name.
    List<Product> findAllByNameContaining(String nameFilter);

}
