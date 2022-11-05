package edu.miu.service.AOP.aspect;


import edu.miu.service.AOP.entity.ActivityLog;
import edu.miu.service.AOP.exception.AopIsAwesomeExeption;
import edu.miu.service.AOP.service.ActivityLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

@Aspect
@Component

public class ExecutionTimeAspect {

    HttpServletRequest request;

    ActivityLogService activityLogService;

    @Autowired
    public ExecutionTimeAspect(HttpServletRequest request, ActivityLogService activityLogService){
        this.activityLogService =activityLogService;
        this.request = request;
    }

    @Pointcut("@annotation(edu.miu.service.AOP.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation(){}

    @Around("executionTimeAnnotation()")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        //special condition
        if(request.getMethod().equals("POST") && request.getHeader("AOP-IS-AWESOME")!=null){
            throw new AopIsAwesomeExeption("Condition matched");
        }

        long start = System.nanoTime();
        var res = proceedingJoinPoint.proceed();
        long end = System.nanoTime();
        long elapsed = end - start;
        double total = (double) elapsed/1_000_000_000;

        ActivityLog log = new ActivityLog();

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH:mm").format(new java.util.Date());
        log.setExecutionTime(timeStamp);
        log.setDuration(total);
        log.setOpration(proceedingJoinPoint.getSignature().getName());

        activityLogService.save(log);
        return res;
    }


}
