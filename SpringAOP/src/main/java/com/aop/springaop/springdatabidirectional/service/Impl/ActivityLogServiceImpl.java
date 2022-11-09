package com.aop.springaop.springdatabidirectional.service.Impl;

import com.aop.springaop.springdatabidirectional.entity.ActivityLog;
import com.aop.springaop.springdatabidirectional.repository.ActivityLogRepository;
import com.aop.springaop.springdatabidirectional.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ActivityLogServiceImpl implements ActivityLogService {
    private ActivityLogRepository activityLogRepository;

    @Autowired
    public ActivityLogServiceImpl(ActivityLogRepository  activityLogRepository) {
        this.activityLogRepository=activityLogRepository;
    }

    @Override
    public ActivityLog save(ActivityLog activityLog) {
        return activityLogRepository.save(activityLog);
    }
}
