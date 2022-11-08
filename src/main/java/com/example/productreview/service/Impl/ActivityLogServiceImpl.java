package com.example.productreview.service.Impl;

import com.example.productreview.entity.DTO.ActivityLogDTO;
import com.example.productreview.entity.DTO.DTOConverter;
import com.example.productreview.entity.uni_and_bi_directional.ActivityLog;
import com.example.productreview.repository.ActivityLogRepo;
import com.example.productreview.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {
    @Autowired
    ActivityLogRepo activityLogRepo;

    @Override
    public List<ActivityLogDTO> findAll() {
        DTOConverter dtoConverter = new DTOConverter();
        return activityLogRepo.findAll().stream()
                .map(activityLog -> dtoConverter.activityLogtoDTO(activityLog))
                .toList();
    }

    @Override
    public void add(ActivityLog activityLog) {
        activityLogRepo.save(activityLog);
    }
}
