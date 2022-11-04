package com.gyawalirajiv.data.services.impl;

import com.gyawalirajiv.data.models.DTOs.ReviewDTO;
import com.gyawalirajiv.data.models.Review;
import com.gyawalirajiv.data.repository.ReviewRepository;
import com.gyawalirajiv.data.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;

    @Override
    public ReviewDTO save(ReviewDTO reviewDTO) {
        return modelMapper.map(reviewRepository.save(modelMapper.map(reviewDTO, Review.class)), ReviewDTO.class);
    }

    @Override
    public List<ReviewDTO> findAll() {
        return reviewRepository.findAll().stream().map(u -> modelMapper.map(u, ReviewDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ReviewDTO find(Long id) {
        return modelMapper.map(reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID!")), ReviewDTO.class);
    }

    @Override
    public ReviewDTO update(Long id, ReviewDTO reviewDTO) {
        Review review = modelMapper.map(reviewDTO, Review.class);
        review = reviewRepository.save(review);
        return modelMapper.map(review, ReviewDTO.class);
    }

    @Override
    public ReviewDTO delete(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID!"));
        reviewRepository.delete(review);
        return modelMapper.map(review, ReviewDTO.class);
    }
}
