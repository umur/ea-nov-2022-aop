package edu.miu.eanov2022aop.service;

import edu.miu.eanov2022aop.model.ActivityLog;

import java.util.List;
import java.util.Optional;

public interface ActivityLogService {
    List<ActivityLog> findAll();
    Optional<ActivityLog> findById(Long id);

    ActivityLog add(ActivityLog activityLog);
    void deleteById(Long id);
}
