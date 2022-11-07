package edu.miu.springdata.controller;

import edu.miu.springdata.aspect.annotation.ExecutionTime;
import edu.miu.springdata.entity.ActivityLog;
import edu.miu.springdata.entity.Address;
import edu.miu.springdata.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/springdata/admin/activitylogs")
public class ActivityLogController {

    private final ActivityLogService activityLogService;

    @ExecutionTime
    @GetMapping
    public List<ActivityLog> getAll() {
        return activityLogService.getAll();
    }

    @ExecutionTime
    @GetMapping("/filterByDate")
    public List<ActivityLog> filterByDate(@RequestParam LocalDate date) {
        return activityLogService.findAllByDate(date);
    }

    @ExecutionTime
    @GetMapping("/filterByDurationGreaterThan")
    public List<ActivityLog> findAllByDurationGreaterThan(@RequestParam Long duration) {
        return activityLogService.findAllByDurationGreaterThan(duration);
    }

}
