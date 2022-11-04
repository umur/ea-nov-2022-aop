package com.example.lab3.service;

import com.example.lab3.entity.ActivityLog;

import java.util.List;

public interface ActivityLogService {
    List<ActivityLog> getAll();
    ActivityLog save(ActivityLog activityLog);
}
