package miu.edu.ea_day3_crudwithdb.service.Impl;

import lombok.RequiredArgsConstructor;
import miu.edu.ea_day3_crudwithdb.DTO.CategoryDto;
import miu.edu.ea_day3_crudwithdb.DTO.ReviewDto;
import miu.edu.ea_day3_crudwithdb.entity.Review;
import miu.edu.ea_day3_crudwithdb.repository.ReviewRepository;
import miu.edu.ea_day3_crudwithdb.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ModelMapper mapper;

    @Override
    public void save(ReviewDto review) {
        reviewRepository.save(mapper.map(review, Review.class));
    }

    @Override
    public void delete(int id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public ReviewDto getById(int id) {
        var reviewEntity = reviewRepository.findById(id).get();
        var reviewDto = mapper.map(reviewEntity, ReviewDto.class);
        return reviewDto;
    }

    @Override
    public List<ReviewDto> getAll() {
        List<ReviewDto> result = StreamSupport
                .stream(reviewRepository.findAll().spliterator(), false)
                .map(r -> mapper.map(r, ReviewDto.class))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public void update(int id, ReviewDto review) {
        var existingReview = reviewRepository.findById(id).get();
        if (existingReview != null) {
            existingReview.setComment(review.getComment());
            reviewRepository.save(existingReview);
        }
    }
}
