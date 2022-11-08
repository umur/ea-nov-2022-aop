package com.example.lab3.aspect;
import com.example.lab3.entity.ActivityLog;
import com.example.lab3.repository.ActivityLogRepo;
import com.example.lab3.service.ActivityLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;


@Aspect
@Component
public class ExecutionTimeAspect {
    @Autowired
    private ActivityLogService activityLogService;

    @Pointcut("@annotation(com.example.lab3.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        ActivityLog activity = new ActivityLog();
        activity.setDate(LocalDate.now());
        activity.setOperation(proceedingJoinPoint.getSignature().getName());
        activity.setDuration(finish);
        activityLogService.save(activity);
        return result;
    }

}