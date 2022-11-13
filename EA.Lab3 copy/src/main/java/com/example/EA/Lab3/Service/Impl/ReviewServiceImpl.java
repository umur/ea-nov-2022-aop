package com.example.EA.Lab3.Service.Impl;

import com.example.EA.Lab3.DTO.ReviewDTO;
import com.example.EA.Lab3.Entity.Review;
import com.example.EA.Lab3.Repo.ReviewRepo;
import com.example.EA.Lab3.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<ReviewDTO> findAll(){
    List<ReviewDTO> reviews = new ArrayList<>();
    reviewRepo.findAll().forEach(review -> reviews.add(modelMapper.map(review, ReviewDTO.class)));
    return reviews;
    }
    @Override
    public ReviewDTO save(ReviewDTO review){
        return modelMapper.map(reviewRepo.save(modelMapper.map(review, Review.class)), ReviewDTO.class);
    }
    @Override
    public ReviewDTO update(Long id, ReviewDTO review){
        Review mappedReview = modelMapper.map(review, Review.class);
        mappedReview = reviewRepo.save(mappedReview);
        return modelMapper.map(mappedReview, ReviewDTO.class);
    }
    @Override
    public void delete(Long id){
        Review review = reviewRepo.findById(id).orElseThrow(() -> new RuntimeException("Invalid Id !"));
        reviewRepo.delete(review);
       //modelMapper.map(review, ReviewDTO.class);
    }
}
