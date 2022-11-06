package miu.edu.ealab4aop.repository;

import miu.edu.ealab4aop.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends JpaRepository<ActivityLog,Long> {
}
