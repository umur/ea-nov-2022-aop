package com.aop.springaop.springdatabidirectional.repository;

import com.aop.springaop.springdatabidirectional.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
    @Query("SELECT p FROM Product p WHERE p.price > ?1")
    List<Product> findProductsByPriceIsGreaterThan(double minPrice);
    @Query("SELECT p FROM Product p WHERE p.price < ?1")
    List<Product> findProductsByPriceIsLessThan(double maxPrice);
    @Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%',:name,'%')")
    List<Product> findProductsByNameIsLikeIgnoreCase(@Param("name")String name);

    @Query("SELECT p FROM Product p inner join Review r on r.product.id=?1")
    List<Product> findProductsByReviewsAndIdContaining(@Param("id")Long  id);
}
