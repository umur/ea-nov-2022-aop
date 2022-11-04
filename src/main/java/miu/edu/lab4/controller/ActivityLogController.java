package miu.edu.lab4.controller;

import miu.edu.lab4.entity.ActivityLog;
import miu.edu.lab4.service.ActivityLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityLogController {

    private final ActivityLogService activityLogService;

    public ActivityLogController(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }

    @GetMapping
    public List<ActivityLog> getAllActivityLog() {
        return activityLogService.getAllActivityLog();
    }


}
