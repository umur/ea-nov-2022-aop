package edu.miu.aop.aop.service.impl;

import edu.miu.aop.aop.aspect.annotation.ExecutionTime;
import edu.miu.aop.aop.aspect.annotation.ValidatePostMethod;
import edu.miu.aop.aop.dto.RequestReviewDTO;
import edu.miu.aop.aop.entity.Review;
import edu.miu.aop.aop.repository.ProductRepository;
import edu.miu.aop.aop.repository.ReviewRepository;
import edu.miu.aop.aop.repository.UserRepository;
import edu.miu.aop.aop.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * Author: Kuylim TITH
 * Date: 11/3/2022
 */
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    @ExecutionTime
    @ValidatePostMethod
    public RequestReviewDTO save(HttpServletRequest request, RequestReviewDTO review) {

        Review r = new Review();
        BeanUtils.copyProperties(review, r, "id");
        // assume client provide valid info
        r.setUser(userRepository.findById(review.getUserId()).get());
        r.setProduct(productRepository.findById(review.getProductId()).get());
        repository.save(r);
        return review;
    }

    @Override
    @ExecutionTime
    public RequestReviewDTO update(Long id, RequestReviewDTO review) {
        Optional<Review> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Review not found!");
        }
        Review o = optional.get();
        BeanUtils.copyProperties(review, o, "id");
        // assume client provide valid info
        o.setProduct(productRepository.findById(review.getProductId()).get());
        o.setUser(userRepository.findById(review.getUserId()).get());
        repository.save(o);
        return review;
    }

    @Override
    @ExecutionTime
    public List<Review> getAllReview() {
        return repository.findAll();
    }

    @Override
    @ExecutionTime
    public List<Review> getAllReviewByProduct(Long productId) {
        return repository.findAllByProductId(productId);
    }
}
