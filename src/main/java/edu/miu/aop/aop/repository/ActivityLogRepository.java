package edu.miu.aop.aop.repository;

import edu.miu.aop.aop.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Kuylim TITH
 * Date: 11/5/2022
 */
@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
}
