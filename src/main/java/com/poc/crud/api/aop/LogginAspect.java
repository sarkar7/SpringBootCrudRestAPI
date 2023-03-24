package com.poc.crud.api.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {

    @Before("execution(* com.poc.crud.api.services.ReqResService.getOneUsers(..))")
    public void beforeLogger(JoinPoint jp) {
        //System.out.println(jp.getSignature());
        String arg = jp.getArgs()[0].toString();
        System.out.println("Before Logger with argument - " + arg);
    }

    @After("execution(* com.poc.crud.api.services.ReqResService.getOneUsers(..))")
    public void afterLogger() {
        System.out.println("After Logger");
    }


    @Pointcut("execution(* com.poc.crud.api.services.ReqResService.getOneUsers(..))")
    public void afterReturningPointCut() {}


    @AfterReturning(pointcut = "afterReturningPointCut()",
    returning = "retVal")
    public void afterReturning(String retVal) {
        System.out.println("After Returning - " + retVal);
    }

}
