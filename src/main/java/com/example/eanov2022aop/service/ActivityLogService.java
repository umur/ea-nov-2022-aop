package com.example.eanov2022aop.service;

import com.example.eanov2022aop.entity.ActivityLog;
import com.example.eanov2022aop.repository.ActivityLogRepository;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogService extends CrudService<ActivityLog, ActivityLogRepository>{

    public ActivityLogService(ActivityLogRepository repository) {
        super(repository);
    }
}
