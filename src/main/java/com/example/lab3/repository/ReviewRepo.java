package com.example.lab3.repository;

import com.example.lab3.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long>{
    @Query("Select r from Review r where r.product.id = :id")
    List<Review> getReviews(@Param("id") Long id);
}
