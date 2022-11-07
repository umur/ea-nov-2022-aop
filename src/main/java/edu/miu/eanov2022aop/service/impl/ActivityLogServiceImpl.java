package edu.miu.eanov2022aop.service.impl;

import edu.miu.eanov2022aop.model.ActivityLog;
import edu.miu.eanov2022aop.service.ActivityLogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {
    @Override
    public List<ActivityLog> findAll() {
        return null;
    }

    @Override
    public Optional<ActivityLog> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public ActivityLog add(ActivityLog activityLog) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
