package com.example.Product.Review.service;

import com.example.Product.Review.entities.join_column.Product;
import com.example.Product.Review.entities.join_column.Review;

import java.util.List;

public interface IReviewService {

    List<Review> findAll();
    Review findById(long id);
    void save(Review review);
    void update(Review review);
    void deleteById(long id);
    void delete(Review review);

    List<Review> findReviewsByProductId(long id);

}
