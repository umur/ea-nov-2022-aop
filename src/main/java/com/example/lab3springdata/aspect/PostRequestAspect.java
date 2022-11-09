package com.example.lab3springdata.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class PostRequestAspect {

    private static class AopIsAwesomeHeaderException extends Exception {

        public AopIsAwesomeHeaderException(String exceptionMessage) {
            super(exceptionMessage);
        }
    }

    private final String apiPointCut="execution(* com.example.lab3springdata.controller.*.*(..))";
//    private final String aopPostPointCut="execution(* com.example.lab3springdata.aspect.PostRequestAspect.aopPostRequest(..))";


    @Pointcut(apiPointCut)
    public void requestCallMethods() {}

//    @Pointcut(aopPostPointCut)
//    public void testThrowingMethod(){}

    @Before("execution(* com.example.lab3springdata.controller.*.*(..))")
    public void aopPostRequest(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {

        System.out.println("okkk");

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();


        if (request.getMethod().equals("POST")) {
            if (request.getHeader("AOP-IS-AWESOME") ==null) {
                throw new AopIsAwesomeHeaderException("AOP not found in header exception");
            }
        }

    }


//    @AfterThrowing("testThrowingMethod()")
//    public void interceptOneMoreTime(JoinPoint joinPoint) {
//        System.out.println("ah wow!");
//    }

}
