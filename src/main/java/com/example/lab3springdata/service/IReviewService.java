package com.example.lab3springdata.service;

import com.example.lab3springdata.model.dto.ReviewDTO;

import java.util.List;

public interface IReviewService {
    List<ReviewDTO> getReviewsByProduct(int id);
}
