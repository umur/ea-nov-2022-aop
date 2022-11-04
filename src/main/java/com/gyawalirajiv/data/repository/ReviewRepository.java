package com.gyawalirajiv.data.repository;

import com.gyawalirajiv.data.models.Review;
import com.gyawalirajiv.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
