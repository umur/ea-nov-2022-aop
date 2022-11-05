package com.miu.edu.aop.aspect;

import com.miu.edu.aop.entity.ActivityLog;
import com.miu.edu.aop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {

    @Autowired
    private ActivityLogService activityLogService;

    @Pointcut("@annotation(com.miu.edu.aop.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calcExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.nanoTime();
        Object result = proceedingJoinPoint.proceed();
        long endTime = System.nanoTime();

        long completedTime = endTime - startTime;
        String operationName = proceedingJoinPoint.getSignature().getName();
        System.out.printf("%s takes ns: %s", operationName, completedTime);

        ActivityLog activityLog = ActivityLog.builder()
                .operation(operationName)
                .duration(completedTime)
                .date(LocalDateTime.now())
                .build();

        activityLogService.save(activityLog);

        return result;
    }
}
