package edu.miu.aop.aop.repository;

import edu.miu.aop.aop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Author: Kuylim TITH
 * Date: 11/3/2022
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceGreaterThan(Double minPrice);

    List<Product> findAllByCategoryNameAndPriceLessThan(String category, Double maxPrice);

    List<Product> findAllByNameContains(String keyword);
}
