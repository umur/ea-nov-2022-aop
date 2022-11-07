package com.example.eanov2022aop.controller;

import com.example.eanov2022aop.entity.ActivityLog;
import com.example.eanov2022aop.service.ActivityLogService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityLogController extends CrudController<ActivityLog, ActivityLogService>{
    public ActivityLogController(ActivityLogService service) {
        super(service);
    }
}
