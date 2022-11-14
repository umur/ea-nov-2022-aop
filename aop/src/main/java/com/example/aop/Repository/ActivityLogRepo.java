package com.example.aop.Repository;


import com.example.aop.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityLogRepo extends JpaRepository<ActivityLog,Integer> {


}
