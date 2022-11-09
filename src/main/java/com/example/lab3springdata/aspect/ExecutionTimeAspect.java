package com.example.lab3springdata.aspect;


import com.example.lab3springdata.model.ActivityLog;
import com.example.lab3springdata.repo.ActivityLogRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class ExecutionTimeAspect {

    private final ActivityLogRepository activityLogRepository;


    public ExecutionTimeAspect(ActivityLogRepository activityLogRepository) {
        this.activityLogRepository = activityLogRepository;
    }

    @Pointcut("@annotation(ExecutionTime)") // my selection criteria, it could be annotation,execution,type,etc..
    public void executeTime(){}

    @Around(value = "executeTime()")
    public Object timeMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object returnValue = joinPoint.proceed();
        long totalTime = System.currentTimeMillis()-startTime;
        String methodName = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
        activityLogRepository.save(new ActivityLog(LocalDate.now(), methodName, (double) totalTime));

        return returnValue;
    }


}
