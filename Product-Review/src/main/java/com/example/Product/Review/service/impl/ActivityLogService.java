package com.example.Product.Review.service.impl;

import com.example.Product.Review.entities.ActivityLog;
import com.example.Product.Review.repo.ActivityLogRepo;
import com.example.Product.Review.service.IActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityLogService implements IActivityLogService {

    private final ActivityLogRepo logRepo;

    @Override
    public List<ActivityLog> findAll() {
        return (List<ActivityLog>) logRepo.findAll();
    }

    @Override
    public ActivityLog findById(long id) {
        return logRepo.findById(id).get();
    }

    @Override
    public void save(ActivityLog activityLog) {
        logRepo.save(activityLog);
    }

    @Override
    public void update(ActivityLog activityLog) {
        logRepo.save(activityLog);
    }

    @Override
    public void deleteById(long id) {
        logRepo.deleteById(id);
    }

    @Override
    public void delete(ActivityLog activityLog) {
        logRepo.delete(activityLog);
    }
}
