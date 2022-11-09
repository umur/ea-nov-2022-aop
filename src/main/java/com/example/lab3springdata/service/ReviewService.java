package com.example.lab3springdata.service;


import com.example.lab3springdata.model.uni_directional.Review;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ReviewService {
    public List<Review> getAll();
    public Review getReviewById(int id);
    public void create(Review review);
    public Review update(int id, Review review);
    public void delete(int id);

    public List<Review> getReviewsByProductId(int id);
}
