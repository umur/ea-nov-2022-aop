package com.example.lab3.repository;

import com.example.lab3.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;

public interface ActivityLogRepo extends CrudRepository<ActivityLog, Long> {
}
