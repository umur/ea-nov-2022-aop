package com.example.productreviewapplication.service.impl;

import com.example.productreviewapplication.model.ActivityLog;
import com.example.productreviewapplication.repository.ActivityLogRepository;
import com.example.productreviewapplication.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {
    private final ActivityLogRepository activityLogRepository;

    @Override
    public ActivityLog saveLog(ActivityLog log) {
        return activityLogRepository.save(log);
    }
}
