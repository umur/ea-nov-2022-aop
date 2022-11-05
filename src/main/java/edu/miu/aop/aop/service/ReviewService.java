package edu.miu.aop.aop.service;

import edu.miu.aop.aop.dto.RequestReviewDTO;
import edu.miu.aop.aop.entity.Review;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/3/2022
 */
public interface ReviewService {

    RequestReviewDTO save(RequestReviewDTO review);

    RequestReviewDTO update(Long id, RequestReviewDTO review);

    List<Review> getAllReview();

    List<Review> getAllReviewByProduct(Long productId);
}
