package com.example.springaop.aop;

import com.example.springaop.entities.ActivityLog;
import com.example.springaop.entities.DTOs.ActivityLogDTO;
import com.example.springaop.repositories.ActivityLogRepo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Autowired
    ActivityLogRepo activityLogRepo;

    @Autowired
    ModelMapper modelMapper;

    @Pointcut("@annotation(com.example.springaop.aop.annotations.ExecutionTime)")
    public void executionTimeAnnotation() {

    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ActivityLogDTO activityLogDTO = new ActivityLogDTO();

        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        long elapsedTime = finish - start;
        activityLogDTO.setDate(LocalDate.now());
        activityLogDTO.setOperation(proceedingJoinPoint.getSignature().getName());
        activityLogDTO.setDuration(elapsedTime);
        activityLogRepo.save(modelMapper.map(activityLogDTO, ActivityLog.class));

        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns: " + finish);
        return result;
    }



}
