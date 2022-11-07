package edu.miu.controller;

import edu.miu.aspect.annotation.ExecutionTime;
import edu.miu.aspect.annotation.LogMe;
import edu.miu.entity.ActivityLog;
import edu.miu.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aop")
public class ActivityLogController {

    @Autowired
    ActivityLogService activityLogservice;

    @ExecutionTime
    @LogMe
    @GetMapping
    public List<ActivityLog> getAll(){
        return activityLogservice.getAll();
    }
}
