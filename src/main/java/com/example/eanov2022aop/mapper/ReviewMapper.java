package com.example.eanov2022aop.mapper;


import com.example.eanov2022aop.dto.ReviewDto;
import com.example.eanov2022aop.entity.Review;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewMapper {
    private final ModelMapper modelMapper;

    public ReviewDto toDto(Review review) {
        return modelMapper.map(review, ReviewDto.class);
    }

    public List <ReviewDto> toDtos(List<Review> reviews) {
        return reviews.stream()
                .map(this::toDto)
                .toList();
    }

    public Review toEntity(ReviewDto reviewDto) {
        return modelMapper.map(reviewDto, Review.class);
    }

    public List<Review> toEntities(List<ReviewDto> reviewDtos) {
        return reviewDtos.stream()
                .map(this::toEntity)
                .toList();
    }
}
