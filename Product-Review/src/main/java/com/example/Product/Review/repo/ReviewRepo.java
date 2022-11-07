package com.example.Product.Review.repo;

import com.example.Product.Review.entities.join_column.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Long> {

    List<Review> findReviewsByProductId(long id);
}
