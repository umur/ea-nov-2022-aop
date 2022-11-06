package com.example.productreviewapplication.repository;

import com.example.productreviewapplication.model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {
    //public List<Review> findReviewsByProductId(Integer id);

    public List<Review> findReviewsByProduct_Id(Integer id);

}
