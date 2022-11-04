package miu.edu.aop.repository;

import miu.edu.aop.model.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<ActivityLog, Long> {
}
