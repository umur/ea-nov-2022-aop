package edu.miu.aop.aop.aspect;

import edu.miu.aop.aop.exception.AopIsAwesomeHeaderException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: Kuylim TITH
 * Date: 11/5/2022
 */
@Aspect
@Component
public class HeaderValidationAspect {

    @Pointcut("@annotation(edu.miu.aop.aop.aspect.annotation.ValidatePostMethod)")
    public void pointCutValidateHeader(){}

    @Pointcut("within(edu.miu.aop.aop.service..*)")
    public void pointCutWithIn() {
    }

    @Before("pointCutValidateHeader() && pointCutWithIn()")
    public void validateIncomingRequestHeader(JoinPoint joinPoint) {
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        if(request.getHeader("AOP-IS-AWESOME") == null) {
            throw new AopIsAwesomeHeaderException("Awesome header not found!");
        }
    }
}
