package com.miu.edu.aop.service.impl;

import com.miu.edu.aop.entity.ActivityLog;
import com.miu.edu.aop.repository.ActivityLogRepository;
import com.miu.edu.aop.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    @Autowired
    private ActivityLogRepository activityLogRepository;

    @Override
    public void save(ActivityLog activityLog) {
        activityLogRepository.save(activityLog);
    }
}
