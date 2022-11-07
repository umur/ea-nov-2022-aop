package com.miu.edu.springaop.service.impl;

import com.miu.edu.springaop.entity.ActivityLog;
import com.miu.edu.springaop.repository.ActivityLogRepository;
import com.miu.edu.springaop.service.ActivityLogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {

    private ActivityLogRepository activityLogRepository;

    @Override
    public void saveActivityLog(ActivityLog activityLog) {
        activityLogRepository.save(activityLog);
    }
}
