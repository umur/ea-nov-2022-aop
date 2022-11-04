package miu.edu.lab4.service;

import miu.edu.lab4.entity.ActivityLog;
import miu.edu.lab4.repository.ActivityLogRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityLogService {
    private ActivityLogRepo activityLogRepo;

    public ActivityLogService( ActivityLogRepo activityLogRepo) {
        this.activityLogRepo = activityLogRepo;

    }

    public void addActivityLog(ActivityLog activityLog){
        activityLogRepo.save(activityLog);
    }

    public List<ActivityLog> getAllActivityLog(){
        return (List<ActivityLog>) activityLogRepo.findAll();
    }

}
