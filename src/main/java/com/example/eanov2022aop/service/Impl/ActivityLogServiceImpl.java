package com.example.eanov2022aop.service.Impl;

import com.example.eanov2022aop.entity.ActivityLog;
import com.example.eanov2022aop.repository.ActivityLogRepo;
import com.example.eanov2022aop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {
    private final ActivityLogRepo activityLogRepo;

    @Override
    @Transactional
    public void save (ActivityLog activityLog) {
        activityLogRepo.save(activityLog);

    }
}
