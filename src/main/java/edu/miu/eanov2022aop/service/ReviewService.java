package edu.miu.eanov2022aop.service;

import edu.miu.eanov2022aop.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    public List<Review> getAll();
    public Optional<Review> getById(long id);
    public Review add(Review review);
    public Review updateById(long id, Review review);
    public void deleteById(long id);
}
