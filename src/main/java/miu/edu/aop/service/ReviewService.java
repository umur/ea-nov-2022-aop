package miu.edu.aop.service;

import miu.edu.aop.dto.ReviewDTO;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<ReviewDTO> findAll();
    Optional<ReviewDTO> findOne(Long id);
    ReviewDTO save(ReviewDTO product);
    void delete(Long id);

    List<ReviewDTO> findAllReviewByProductId(Long id);
}
