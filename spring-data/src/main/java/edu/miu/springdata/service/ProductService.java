package edu.miu.springdata.service;

import edu.miu.springdata.entity.Category;
import edu.miu.springdata.entity.Product;
import edu.miu.springdata.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    void save(Product product);

    void delete(Long productId);

    Product getById(Long productId);

    List<Product> getAll();

    List<Product> findAllByPriceGreaterThan(double minPrice);

    List<Product> findAllByNameContaining(String name);

    List<Review> findReviewByProductId(Long productId);

}
