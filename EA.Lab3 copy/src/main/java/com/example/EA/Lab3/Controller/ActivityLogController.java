package com.example.EA.Lab3.Controller;

import com.example.EA.Lab3.Aop.ExecutionTime;
import com.example.EA.Lab3.Entity.ActivityLog;
import com.example.EA.Lab3.Service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("activities")
@RequiredArgsConstructor
public class ActivityLogController {
    private final ActivityLogService service;

    @GetMapping()
    @ExecutionTime
    public List<ActivityLog> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityLog> get(@PathVariable Long id) {
        return service.findOne(id).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ActivityLog create(@RequestBody ActivityLog activity) {
        return service.save(activity);
    }

    @PutMapping("/{id}")
    public ActivityLog update(@PathVariable Long id, @RequestBody ActivityLog activity) {
        activity.setId(id);
        return service.save(activity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
