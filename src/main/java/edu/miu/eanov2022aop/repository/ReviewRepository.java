package edu.miu.eanov2022aop.repository;

import edu.miu.eanov2022aop.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAll();

    Review getReferenceById(Long id);
}
