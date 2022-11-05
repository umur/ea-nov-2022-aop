package com.miu.edu.aop.dto;

import com.miu.edu.aop.entity.Product;
import com.miu.edu.aop.entity.Review;
import com.miu.edu.aop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {

    private int id;

    private String comment;

    private int productId;

    private int userId;

    public static ReviewDto convertFrom(Review review) {
        if (review == null) {
            return null;
        }
        return new ReviewDto(
            review.getId(),
            review.getComment(),
            review.getProduct().getId(),
            review.getUser().getId()
        );
    }

    public static Review convertTo(ReviewDto review) {
        if (review == null) {
            return null;
        }

        return new Review(
                review.getId(),
                review.getComment(),
                new Product(review.getProductId()),
                new User(review.getUserId())
        );
    }
}
