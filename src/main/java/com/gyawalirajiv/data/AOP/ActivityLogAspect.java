package com.gyawalirajiv.data.AOP;

import com.gyawalirajiv.data.ApoIsAwesomeHeaderException;
import com.gyawalirajiv.data.repository.ActivityLogRepository;
import com.gyawalirajiv.data.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Date;

@Aspect
@Component
@RequiredArgsConstructor
public class ActivityLogAspect {

    private final HttpServletRequest httpServletRequest;
    private final ActivityLogRepository activityLogRepository;

    @Pointcut("@annotation(com.gyawalirajiv.data.AOP.ExecutionTime)")
    public void executionTimeAnnotation(){
    }

    @Around("executionTimeAnnotation()")
    public Object calculateTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        Object proceed = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();

        ActivityLog log = new ActivityLog();
        log.setLocalDate(LocalDate.now());
        log.setDuration(finish - start);
        log.setOperation(proceedingJoinPoint.getSignature().toShortString());
        activityLogRepository.save(log);
        return proceed;
    }

    @Pointcut("execution(* com.gyawalirajiv.data.services.*.*(..))")
    public void servicesExecutionPointCut(){

    }

    @Before("servicesExecutionPointCut()")
    public void serviceGuardForPostMethods(JoinPoint joinPoint) throws ApoIsAwesomeHeaderException {
        if(httpServletRequest.getMethod().equals("POST")){
            if(httpServletRequest.getHeader("AOP-IS-AWESOME") == null){
                throw new ApoIsAwesomeHeaderException("AOP-IS-AWESOME is required in Header!");
            }
        }
    }
}
