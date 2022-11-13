package com.example.EA.Lab3.Service;

import com.example.EA.Lab3.Entity.ActivityLog;

import java.util.List;
import java.util.Optional;

public interface ActivityLogService {
    List<ActivityLog> findAll();
    Optional<ActivityLog> findOne(Long id);
    ActivityLog save(ActivityLog product);
    void delete(Long id);
}
