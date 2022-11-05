package edu.miu.aop.aop.aspect;

import edu.miu.aop.aop.entity.ActivityLog;
import edu.miu.aop.aop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Author: Kuylim TITH
 * Date: 11/5/2022
 */
@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {

    private final ActivityLogService service;

    @Pointcut("@annotation(edu.miu.aop.aop.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        String operation = proceedingJoinPoint.getSignature().getDeclaringTypeName() + " : "
                + proceedingJoinPoint.getSignature().getName();
        service.logExecutionTime(constructActivityLog(operation, (finish - start)));
        return result;
    }

    private ActivityLog constructActivityLog(String operation, Long executeTime) {
        ActivityLog log = new ActivityLog();
        log.setDuration(executeTime);
        log.setOperation(operation);
        log.setLocalDateTime(LocalDateTime.now());
        return log;
    }
}
