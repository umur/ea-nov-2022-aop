package com.example.lab3springdata.repo;

import com.example.lab3springdata.model.ActivityLog;
import org.springframework.data.repository.CrudRepository;

public interface ActivityLogRepository extends CrudRepository<ActivityLog, Long> {
}
