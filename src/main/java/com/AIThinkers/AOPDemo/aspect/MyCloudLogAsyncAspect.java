package com.AIThinkers.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("com.AIThinkers.AOPDemo.aspect.AopPointcutExpressions.forDAOPackageNoGetterSetter()")
    public void logToCloudAdvice(){
        System.out.println("\n =====>>> logging into cloud in asyn fashion()");
    }
}
