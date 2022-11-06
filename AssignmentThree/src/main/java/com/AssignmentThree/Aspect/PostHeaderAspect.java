package com.AssignmentThree.Aspect;

import com.AssignmentThree.Exceptions.AopIsAwesomeHeaderException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class PostHeaderAspect {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postCall() {
    }

    @Before("postCall()")
    public void throwException(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();
        if (request.getHeader("AOP-IS-AWESOME") == null) {
            throw new AopIsAwesomeHeaderException();
        }
        else
            System.out.println("All Good");
    }

}
