package com.AIThinkers.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
    @Before("com.AIThinkers.AOPDemo.aspect.AopPointcutExpressions.forDAOPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n ====>>>> Exceuting performApiAnalytics()");
    }
}
