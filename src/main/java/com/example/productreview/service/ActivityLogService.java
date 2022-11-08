package com.example.productreview.service;

import com.example.productreview.entity.DTO.ActivityLogDTO;
import com.example.productreview.entity.uni_and_bi_directional.ActivityLog;

import java.util.List;

public interface ActivityLogService {
    List<ActivityLogDTO> findAll();
    void add(ActivityLog activityLog);
}
