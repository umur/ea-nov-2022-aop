package com.example.Product.Review.repo;

import com.example.Product.Review.entities.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends CrudRepository<ActivityLog, Long> {
}
