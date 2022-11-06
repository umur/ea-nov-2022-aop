package miu.edu.ealab4aop.service.impl;

import miu.edu.ealab4aop.entity.ActivityLog;
import miu.edu.ealab4aop.repository.ActivityLogRepo;
import miu.edu.ealab4aop.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {
    @Autowired
    private ActivityLogRepo repo;

    @Override
    public List<ActivityLog> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<ActivityLog> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public ActivityLog addActivity(ActivityLog activityLog) {
        return repo.save(activityLog);
    }
}
