package com.example.EA.Lab3.Repo;

import com.example.EA.Lab3.Entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends JpaRepository<ActivityLog, Long> {
}
