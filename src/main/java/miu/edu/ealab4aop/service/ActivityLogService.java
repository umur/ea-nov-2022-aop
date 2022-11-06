package miu.edu.ealab4aop.service;

import miu.edu.ealab4aop.entity.ActivityLog;

import java.util.List;
import java.util.Optional;

public interface ActivityLogService {
    List<ActivityLog> findAll();
    Optional<ActivityLog> findById(Long id);
    ActivityLog addActivity(ActivityLog activityLog);
}
