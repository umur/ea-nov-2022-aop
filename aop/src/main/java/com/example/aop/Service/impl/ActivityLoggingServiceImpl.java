package com.example.aop.Service.impl;

import com.example.aop.Repository.ActivityLogRepo;
import com.example.aop.Service.ActivityLoggingService;
import com.example.aop.entity.ActivityLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityLoggingServiceImpl implements ActivityLoggingService {
   @Autowired
   private ActivityLogRepo activityLogRepo;


    @Override
    public void saveActivity(ActivityLog activityLog) {
        activityLogRepo.save(activityLog);
    }
}
