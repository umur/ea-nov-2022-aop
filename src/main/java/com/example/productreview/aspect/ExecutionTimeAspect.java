package com.example.productreview.aspect;

import com.example.productreview.entity.uni_and_bi_directional.ActivityLog;
import com.example.productreview.service.ActivityLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {
    @Autowired
    ActivityLogService activityLogService;

    @Pointcut("@annotation(com.example.productreview.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation(){
    }
    @Around("executionTimeAnnotation()")
    public Object calculateTimeTaken(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        Long finish = System.nanoTime();

        ActivityLog activityLog = new ActivityLog();
        activityLog.setDuration(finish);
        activityLog.setOperation(proceedingJoinPoint.getSignature().getName());
        System.out.println("Test Called");
        activityLogService.add(activityLog);

        return result;
    }

}
