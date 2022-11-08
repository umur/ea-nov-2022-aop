package com.example.productreview.controller;

import com.example.productreview.entity.DTO.ActivityLogDTO;
import com.example.productreview.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/activity_log")
public class ActivityLogController {
    @Autowired
    ActivityLogService activityLogService;

    @GetMapping
    List<ActivityLogDTO> findAll(){
        return activityLogService.findAll();
    }
}
