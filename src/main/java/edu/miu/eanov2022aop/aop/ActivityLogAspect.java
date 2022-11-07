package edu.miu.eanov2022aop.aop;

import edu.miu.eanov2022aop.exception.AopIsAwesomeHeaderException;
import edu.miu.eanov2022aop.model.ActivityLog;
import edu.miu.eanov2022aop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.HttpMethodConstraintElement;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Objects;

@Aspect
@Component
@RequiredArgsConstructor
public class ActivityLogAspect {
    private final ActivityLogService activityLogService;
    private final HttpServletRequest httpServletRequest;

    @Pointcut("@annotation(edu.miu.eanov2022aop.annotation)")
    public void triggerExecutionTime() {}

    @Pointcut("within(edu.miu.eanov2022aop.service.*)")
    public void triggerService() {}

    @Around("triggerExecutionTime")
    Object triggerExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long started = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        String operation = joinPoint.getSignature().getName();
        long duration = System.currentTimeMillis() - started;
        LocalDateTime date = LocalDateTime.now();
        activityLogService.add(new ActivityLog(null, date, operation, duration));
        return object;
    }

    @Before("triggerService()")
    void triggeredService(JoinPoint joinPoint ) throws RuntimeException, AopIsAwesomeHeaderException {
        if(Objects.equals(httpServletRequest.getMethod(), HttpMethod.POST.toString()) && Objects.isNull(httpServletRequest.getHeader("AOP-IS-AWESOME"))){
            throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME IS NOT LOADED HEADER");
        }
    }
}
