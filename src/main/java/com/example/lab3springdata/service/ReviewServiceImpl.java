package com.example.lab3springdata.service;

import com.example.lab3springdata.model.Review;
import com.example.lab3springdata.model.dto.ReviewDTO;
import com.example.lab3springdata.repository.ReviewRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class ReviewServiceImpl implements IReviewService {

    private final ReviewRepo reviewRepo;
    private final ModelMapper modelMapper = new ModelMapper();
    private final Function<Review, ReviewDTO> reviewMapper = review -> modelMapper.map(review, ReviewDTO.class);

    public ReviewServiceImpl(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;

    }

    @Override
    public List<ReviewDTO> getReviewsByProduct(int id) {
        List<Review> reviewsByProductId = reviewRepo.findReviewsByProductId(id);

        return reviewsByProductId.stream()
                .map(reviewMapper)
                .toList();
    }
}
