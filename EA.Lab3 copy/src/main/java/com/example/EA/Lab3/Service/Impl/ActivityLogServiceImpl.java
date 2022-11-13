package com.example.EA.Lab3.Service.Impl;

import com.example.EA.Lab3.Entity.ActivityLog;
import com.example.EA.Lab3.Repo.ActivityLogRepo;
import com.example.EA.Lab3.Service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepo repository;
    static ModelMapper mapper = new ModelMapper();


    public List<ActivityLog> findAll() {
        return repository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    public Optional<ActivityLog> findOne(Long id) {
        return repository.findById(id);
    }

    public ActivityLog save(ActivityLog activity) {
        return repository.save(activity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
