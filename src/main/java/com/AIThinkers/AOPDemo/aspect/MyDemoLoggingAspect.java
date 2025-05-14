package com.AIThinkers.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //this is where we add all of our related advices for logging

  //  @Before("exceution(public void addAccount())")

   // @Before("exceution(public void add*())")

    @Before("exceution(* add*())")
    public void beforeAddAccountAdvice(){

        System.out.println("Exceuting @before advice on method");
    }
}
