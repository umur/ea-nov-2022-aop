package com.example.lab3.controller;

import com.example.lab3.entity.ActivityLog;
import com.example.lab3.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class ActivityLogController {
    @Autowired
    private ActivityLogService activityLogService;
    @GetMapping
    public List<ActivityLog> getAll(){
        return activityLogService.getAll();
    }
}
