package com.example.lab3springdata.repository;

import com.example.lab3springdata.model.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends CrudRepository<ActivityLog, Integer> {
}
