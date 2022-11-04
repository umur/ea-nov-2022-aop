package com.example.eanov2022springdataI.repository;

import com.example.eanov2022springdataI.entity.Category;
import com.example.eanov2022springdataI.entity.Product;
import java.util.List;

public interface ProductRepository extends CrudRepositoryInterface<Product>{
    List<Product> findAllByPriceGreaterThanEqual(Double price);
    List<Product> findAllByCategoryIdAndPriceLessThanEqual(String category_id, Double price);
    List<Product> findAllByNameContains(String name);
}
