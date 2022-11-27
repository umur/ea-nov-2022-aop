package com.example.lab4.repository;

import com.example.lab4.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends CrudRepository<ActivityLog,Long> {
}
