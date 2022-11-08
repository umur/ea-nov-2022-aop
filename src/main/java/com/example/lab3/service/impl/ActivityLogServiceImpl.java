package com.example.lab3.service.impl;

import com.example.lab3.entity.ActivityLog;
import com.example.lab3.repository.ActivityLogRepo;
import com.example.lab3.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ActivityLogServiceImpl implements ActivityLogService {
    @Autowired
    private ActivityLogRepo activityLogRepo;

    @Override
    public List<ActivityLog> getAll() {
        return (List<ActivityLog>) activityLogRepo.findAll();
    }

    @Override
    public ActivityLog save(ActivityLog activityLog) {
         return activityLogRepo.save(activityLog);
    }
}
