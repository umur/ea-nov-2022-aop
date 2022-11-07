package com.example.eanov2022aop.service;

import com.example.eanov2022aop.entity.Review;
import com.example.eanov2022aop.repository.ReviewRepository;
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
