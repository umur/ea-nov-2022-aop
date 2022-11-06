package com.example.productreviewapplication.repository;

import com.example.productreviewapplication.model.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
}
