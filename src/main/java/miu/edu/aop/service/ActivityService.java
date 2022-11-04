package miu.edu.aop.service;

import miu.edu.aop.dto.ActivityLogDTO;

import java.util.List;
import java.util.Optional;

public interface ActivityService {
    List<ActivityLogDTO> findAll();
    Optional<ActivityLogDTO> findOne(Long id);
    ActivityLogDTO save(ActivityLogDTO product);
    void delete(Long id);
}
