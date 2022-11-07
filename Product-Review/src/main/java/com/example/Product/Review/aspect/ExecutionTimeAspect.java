package com.example.Product.Review.aspect;

import com.example.Product.Review.entities.ActivityLog;
import com.example.Product.Review.service.impl.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {

    private final ActivityLogService logService;

    @Pointcut("@annotation(com.example.Product.Review.aspect.annotation.ExecutionTime)")
    public void meteredMethod(){}

    @Around("meteredMethod()")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();
        Object result = joinPoint.proceed();
        long endTime = System.nanoTime();
        ActivityLog activityLog = createActivityLogger(
                joinPoint.getSignature().getName(),
                endTime - startTime
        );
        logService.save(activityLog);
        return result;
    }

    private ActivityLog createActivityLogger(String operation, long duration) {
        return ActivityLog.builder()
                .operation(operation)
                .duration(duration)
                .build();
    }
}
