package edu.miu.service.impl;

import edu.miu.entity.ActivityLog;
import edu.miu.repository.ActivityLogRepo;
import edu.miu.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityLogImpl implements ActivityLogService {
    @Autowired
    private ActivityLogRepo activityLogRepo;

    public void save(ActivityLog activityLog)
    {
        activityLogRepo.save(activityLog);
    }


    @Override
    public List<ActivityLog> getAll() {
        return (List<ActivityLog>) activityLogRepo.findAll();
    }
}
