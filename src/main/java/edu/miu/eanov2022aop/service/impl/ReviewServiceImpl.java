package edu.miu.eanov2022aop.service.impl;

import edu.miu.eanov2022aop.model.Review;
import edu.miu.eanov2022aop.repository.ReviewRepository;
import edu.miu.eanov2022aop.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepo;

    @Override
    public List<Review> getAll() {
        return reviewRepo.findAll();
    }

    @Override
    public Optional<Review> getById(long id) {
        return reviewRepo.findById(id);
    }

    @Override
    public Review add(Review review) {
        return reviewRepo.save(review);
    }

    @Override
    public Review updateById(long id, Review review) {
        Review newReview = reviewRepo.getReferenceById(id);
        newReview.setComment(review.getComment());
        newReview.setUser(review.getUser());
        newReview.setProduct(review.getProduct());
        return reviewRepo.save(newReview);
    }

    @Override
    public void deleteById(long id) {
        reviewRepo.deleteById(id);
    }
}
