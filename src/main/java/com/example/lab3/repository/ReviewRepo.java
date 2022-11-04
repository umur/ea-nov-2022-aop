package com.example.lab3.repository;

import com.example.lab3.entity.bidirectional.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepo extends CrudRepository<Review, Long> {
}
