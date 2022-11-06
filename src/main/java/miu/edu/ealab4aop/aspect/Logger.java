package miu.edu.ealab4aop.aspect;

import miu.edu.ealab4aop.entity.ActivityLog;
import miu.edu.ealab4aop.exception.AopIsAwesomeHeaderException;
import miu.edu.ealab4aop.service.ActivityLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Aspect
@Component
public class Logger {
    @Autowired
    HttpServletRequest httpRequest;

    @Autowired
    ActivityLogService activityLogService;

    @Pointcut("@annotation(miu.edu.ealab4aop.aspect.ExecutionTimeAspect)")
    public void executionTime() {
    }

    @Pointcut("within(miu.edu.ealab4aop.service.*.*)")
    public void serviceClass() {
    }

    @Around("executionTime()")
    public Object performanceManagement(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        ActivityLog activityLog = new ActivityLog();
        Object result = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        String operation = proceedingJoinPoint.getSignature().getName();
        LocalDateTime time = LocalDateTime.now();
        activityLog.setDate(time);
        activityLog.setDuration(timeTaken);
        activityLog.setOperation(operation);
        activityLogService.addActivity(activityLog);
        return result;
    }

    @Around("serviceClass()")
    public Object checkHeader(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        result =proceedingJoinPoint.proceed();

//        if(httpRequest.getMethod().equals("POST")){
//            if( httpRequest.getHeader("AOP-IS-AWESOME") != null){
//                result =proceedingJoinPoint.proceed();
//                return null;
//            }
//            else{
//                throw new AopIsAwesomeHeaderException();
//            }
//        }
//        else {
//            result= proceedingJoinPoint.proceed();
//
//        }
        return null;
    }

}
