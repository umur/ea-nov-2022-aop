package miu.edu.lab4.service;

import miu.edu.lab4.entity.Review;
import miu.edu.lab4.repository.ReviewRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private ReviewRepo reviewRepo;

    public ReviewService(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    public void addReview(Review review) {
        reviewRepo.save(review);
    }

    public List<Review> getAllReviews() {

        return (List<Review>) reviewRepo.findAll();
    }

    public List<Review> getReviewByProductId(int productId) {

        return reviewRepo.findByProductId(productId);
    }

    public Review getReviewById(int id) {

        return reviewRepo.findById(id).get();
    }
}
