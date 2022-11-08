package com.example.productreview.repository;

import com.example.productreview.entity.uni_and_bi_directional.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityLogRepo extends CrudRepository<ActivityLog, Long> {
    List<ActivityLog> findAll();
}
