package edu.miu.aop.aop.service;

import edu.miu.aop.aop.entity.ActivityLog;

/**
 * Author: Kuylim TITH
 * Date: 11/5/2022
 */
public interface ActivityLogService {

    ActivityLog logExecutionTime(ActivityLog log);
}
