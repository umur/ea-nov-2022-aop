package edu.miu.springdata.repository;

import edu.miu.springdata.entity.Category;
import edu.miu.springdata.entity.Product;
import edu.miu.springdata.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {

    List<Product> findAllByPriceGreaterThan(double minPrice);

    //List<Product> findAllByCategoryAndPriceLessThan(Category cat, double maxPrice);

    List<Product> findAllByNameContaining(String name);

}
