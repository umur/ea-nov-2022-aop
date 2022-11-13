package com.example.EA.Lab3.Service;

import com.example.EA.Lab3.DTO.ReviewDTO;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> findAll();
    ReviewDTO save(ReviewDTO review);
    ReviewDTO update(Long id, ReviewDTO review);
    void delete(Long id);
}
