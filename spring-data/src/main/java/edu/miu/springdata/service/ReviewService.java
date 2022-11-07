package edu.miu.springdata.service;

import edu.miu.springdata.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {

    void save(Review review);

    void delete(Long reviewId);

    Review getById(Long reviewId);

    List<Review> getAll();

}
