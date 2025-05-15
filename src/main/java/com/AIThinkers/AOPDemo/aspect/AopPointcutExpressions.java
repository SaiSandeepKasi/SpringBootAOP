package com.AIThinkers.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopPointcutExpressions {
    @Pointcut("exceution(* com.AIThinkers.AOPDemo.DAO.*.*(..))")
    public void forDAOPackage(){
    }
    //pointcut for getter methods
    @Pointcut("exceution(* com.AIThinkers.AOPDemo.DAO.*.get*(..))")
    public void getter(){
    }
    //pointcut for setter methods
    @Pointcut("exceution(* com.AIThinkers.AOPDemo.DAO.*.set*(..))")
    public void setter(){
    }
    //Combine pointcut:including the package ...exclude the setter && gettter
    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDAOPackageNoGetterSetter(){

    }
}
