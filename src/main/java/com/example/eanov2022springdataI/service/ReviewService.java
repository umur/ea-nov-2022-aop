package com.example.eanov2022springdataI.service;

import com.example.eanov2022springdataI.entity.Review;
import com.example.eanov2022springdataI.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService extends CrudService<Review, ReviewRepository>{

    public ReviewService(ReviewRepository repository) {
        super(repository);
    }

    public List<Review> findAllReviewByProductId(String id) {
        return repository.findAllByUserId(id)
                .stream()
                .toList();
    }
}
