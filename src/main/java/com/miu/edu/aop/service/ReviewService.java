package com.miu.edu.aop.service;

import com.miu.edu.aop.dto.ReviewDto;

import java.util.List;

public interface ReviewService {

    /**
     * Get Reviews By ProductId
     * @return Reviews
     */
    List<ReviewDto> getReviewsByProductId(int productId);

    /**
     * Get Review By id
     *
     * @param id
     * @return a Review
     */
    ReviewDto getReviewById(int id);

    /**
     * Update a Review
     * @param review
     */
    void updateReview(ReviewDto review);

    /**
     * Add a Review
     * @param review
     */
    void addReview(ReviewDto review);

    /**
     * Remove a Review by id
     * @param id
     */
    void removeById(int id);

}
