package miu.edu.ea_day3_crudwithdb.service.Impl;

import lombok.RequiredArgsConstructor;
import miu.edu.ea_day3_crudwithdb.entity.ActivityLog;
import miu.edu.ea_day3_crudwithdb.repository.ActivityLogRepository;
import miu.edu.ea_day3_crudwithdb.service.ActivityLogService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {
    private final ActivityLogRepository activityLogRepository;

    @Override
    public void logActivity(ActivityLog activityLog) {
         activityLogRepository.save(activityLog);
    }
}
