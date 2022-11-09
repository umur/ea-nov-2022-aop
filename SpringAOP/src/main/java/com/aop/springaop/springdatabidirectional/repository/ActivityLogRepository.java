package com.aop.springaop.springdatabidirectional.repository;

import com.aop.springaop.springdatabidirectional.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;

public interface ActivityLogRepository extends CrudRepository<ActivityLog, Integer> {
}
