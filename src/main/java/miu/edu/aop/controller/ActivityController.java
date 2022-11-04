package miu.edu.aop.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.aop.annotation.ExecutionTime;
import miu.edu.aop.dto.ActivityLogDTO;
import miu.edu.aop.service.ActivityServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityServiceImpl service;

    @GetMapping()
    @ExecutionTime
    public List<ActivityLogDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityLogDTO> get(@PathVariable Long id) {
        return service.findOne(id).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ActivityLogDTO create(@RequestBody ActivityLogDTO activity) {
        return service.save(activity);
    }

    @PutMapping("/{id}")
    public ActivityLogDTO update(@PathVariable Long id, @RequestBody ActivityLogDTO activity) {
        activity.setId(id);
        return service.save(activity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}