package com.aop.springaop.aspectAdvice;

import com.aop.springaop.springdatabidirectional.DTOs.ActivityLogDTO;
import com.aop.springaop.springdatabidirectional.entity.ActivityLog;
import com.aop.springaop.springdatabidirectional.service.ActivityLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Aspect
@Component
@Slf4j
public class ExecutionTimeTracker {

    @Autowired
    private ActivityLogService activityLogService;

    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private ModelMapper modelMapper;

    @Around("@annotation(com.aop.springaop.aspectAdvice.ExecutionTime)")
    public Object executionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ActivityLogDTO activityLogDTO=new ActivityLogDTO();

        Long startTime = System.currentTimeMillis();
        Object obj = proceedingJoinPoint.proceed();
        Long endTime = System.currentTimeMillis();
        double duration=endTime - startTime;
        activityLogDTO.setDuration(duration);
        activityLogDTO.setDate(LocalDate.now());
        activityLogDTO.setOperation(String.valueOf(proceedingJoinPoint.getSignature()));
        activityLogService.save(modelMapper.map(activityLogDTO, ActivityLog.class));
        log.info("Method name" + proceedingJoinPoint.getSignature() + " Time Taken to execute: " + duration);
        return obj;
    }
    @Pointcut("execution(* com.aop.springaop.springdatabidirectional.service.*.*(..))")
    public void servicePointCutMethod(){
    }
    @Before("servicePointCutMethod()")
    public void serviceForPostMethods(JoinPoint joinPoint) throws ApoIsAwesomeHeaderException{
        if(httpServletRequest.getMethod().equals("POST")){
            if(httpServletRequest.getHeader("AOP-IS-AWESOME")==null){
                throw new ApoIsAwesomeHeaderException("AopIsAwesomeHeaderException");
            }
        }

    }
}
