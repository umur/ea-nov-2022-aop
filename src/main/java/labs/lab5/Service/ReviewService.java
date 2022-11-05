package labs.lab5.Service;


import labs.lab5.Entity.UniReview;
import labs.lab5.Repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository rr){
        this.reviewRepository = rr;
    }

    public List<UniReview> getReviews(){

        return this.reviewRepository.findAll();
    }

    public UniReview getReviewById(String id){
        Optional<UniReview> rev = this.reviewRepository.findById(id);
        return rev.orElse(null);
    }

    public List<UniReview> getReviewsByProductId(String id){
        return this.reviewRepository.findAllReviewsByProductId(id);
    }

    public UniReview addReview(UniReview r){
        return this.reviewRepository.save(r);
    }

    public UniReview updateReview(UniReview r){
        return this.reviewRepository.save(r);
    }

    public void deleteReviewById(String id){
        this.reviewRepository.deleteById(id);
    }
}
