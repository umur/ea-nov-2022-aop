package labs.lab5.Service;

import labs.lab5.Entity.ActivityLog;
import labs.lab5.Repository.ActivityLogRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class ActivityLogService {
    ActivityLogRepository activityLogRepository;

    public ActivityLog addLogEntry(ActivityLog a){
        return this.activityLogRepository.save(a);
    }
}
