package com.gyawalirajiv.data.services;

import com.gyawalirajiv.data.models.DTOs.ReviewDTO;

import java.util.List;

public interface ReviewService {
    ReviewDTO save(ReviewDTO reviewDTO);

    List<ReviewDTO> findAll();

    ReviewDTO find(Long id);

    ReviewDTO update(Long id, ReviewDTO reviewDTO);

    ReviewDTO delete(Long id);
}
