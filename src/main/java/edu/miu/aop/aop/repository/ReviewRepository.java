package edu.miu.aop.aop.repository;

import edu.miu.aop.aop.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/3/2022
 */
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByProductId(Long productId);
}
