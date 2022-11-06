package com.example.lab3.repository;

import com.example.lab3.model.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface ActivityLogRepo extends CrudRepository<ActivityLog, Long> {

}
