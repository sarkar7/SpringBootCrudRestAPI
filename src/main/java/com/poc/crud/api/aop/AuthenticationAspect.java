package com.poc.crud.api.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {

    @Pointcut("within(com.poc.crud.api..*)")
    public void authenticationPointCut() {
    }

    @Pointcut("within(com.poc.crud.api..*)")
    public void authorizationPointCut() {
    }

    @Before("authenticationPointCut() && authorizationPointCut()")
    public void authenticate() {
        System.out.println("Authenticating the Request");
    }

}
