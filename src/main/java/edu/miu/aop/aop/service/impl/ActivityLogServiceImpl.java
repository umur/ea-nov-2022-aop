package edu.miu.aop.aop.service.impl;

import edu.miu.aop.aop.entity.ActivityLog;
import edu.miu.aop.aop.repository.ActivityLogRepository;
import edu.miu.aop.aop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Author: Kuylim TITH
 * Date: 11/5/2022
 */
@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {
    private final ActivityLogRepository repository;

    @Override
    public ActivityLog logExecutionTime(ActivityLog log) {
        return repository.save(log);
    }
}
