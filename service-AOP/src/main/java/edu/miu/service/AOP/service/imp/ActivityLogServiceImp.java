package edu.miu.service.AOP.service.imp;

import edu.miu.service.AOP.entity.ActivityLog;
import edu.miu.service.AOP.repo.ActivityLogRepo;
import edu.miu.service.AOP.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogServiceImp  implements ActivityLogService {

    private ActivityLogRepo activityLogRepo;

    @Autowired
    public ActivityLogServiceImp(ActivityLogRepo activityLogRepo){
        this.activityLogRepo= activityLogRepo;
    }

    public void save(ActivityLog activityLog){
        activityLogRepo.save(activityLog);
    }
}
