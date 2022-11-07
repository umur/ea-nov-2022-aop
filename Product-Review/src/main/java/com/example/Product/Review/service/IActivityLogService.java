package com.example.Product.Review.service;

import com.example.Product.Review.entities.ActivityLog;
import java.util.List;

public interface IActivityLogService {

    List<ActivityLog> findAll();
    ActivityLog findById(long id);
    void save(ActivityLog activityLog);
    void update(ActivityLog activityLog);
    void deleteById(long id);
    void delete(ActivityLog activityLog);
}
