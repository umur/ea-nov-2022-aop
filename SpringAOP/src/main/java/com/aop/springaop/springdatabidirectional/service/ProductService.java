package com.aop.springaop.springdatabidirectional.service;


import com.aop.springaop.springdatabidirectional.entity.Product;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    Product updateProduct(Product product);
    Product getProductById(Long id);
    void deleteProduct(Long id);
    List<Product> getAllProducts();
     List<Product> findProductsByPriceIsGreaterThan(double minPrice);
     List<Product> findProductsByPriceIsLessThan(double maxPrice);
    List<Product> findProductsByNameIsLikeIgnoreCase(String name);
    List<Product> findProductsByReviewsAndIdContaining(@Param("id")Long  id);

}
