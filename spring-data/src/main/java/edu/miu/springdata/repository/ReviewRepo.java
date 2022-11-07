package edu.miu.springdata.repository;

import edu.miu.springdata.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Long> {

    //List<Review> findByProductId(Long productId);
}
