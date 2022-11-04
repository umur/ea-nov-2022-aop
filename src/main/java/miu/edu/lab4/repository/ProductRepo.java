package miu.edu.lab4.repository;

import miu.edu.lab4.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer>, ProductDao {

    // By Naming Convention
    List<Product> findProductsByPriceGreaterThan(double minPrice);
    List<Product> findByCategoryNameAndPriceGreaterThan(String categoryName, Double price);
    List<Product> findByNameContaining(String name);
    // OR
    //List<Product> findProductByNameContaining(String name);
}
