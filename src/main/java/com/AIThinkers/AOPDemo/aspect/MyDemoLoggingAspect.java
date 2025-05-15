package com.AIThinkers.AOPDemo.aspect;

import com.AIThinkers.AOPDemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.List;
//import java.lang.classfile.MethodSignature;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    //this is where we add all of our related advices for logging

  //  @Before("exceution(public void addAccount())")
   // @Before("exceution(public void add*())")
//--------------------------------
    //Here we Are usingbvPointCut Declaration to minimize the @befor advice
    //just by mentioning pointcut method name

//------------------------------------------

    @Around("exceution(* com.AIThinkers.AOPDemo.service.*.getFortune(..))")
    public Object aroundFortune(
            ProceedingJoinPoint theproceedingJoinPoint)throws Throwable{

        //print out the which method we are advising on
        String method= theproceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n =====.>>>>> exceuting @AfterThrowing on method :"+ method);

        //getting TimeStamp
        //long begin =System.currentTimeMillis();

        long begin = System.nanoTime();

        //now let's execute the method
        Object result = null;

        try {
            result = theproceedingJoinPoint.proceed();
        } catch (Exception Exc) {
            //log the exception
            System.out.println(Exc.getMessage());

         //rethrow exceptions
            throw Exc;
        }
        //get end the TimeStamp
       // long end=System.currentTimeMillis();

        long end=System.nanoTime();

        //compute duration and display it
        long duration=end - begin;
        System.out.println("\n=====> Duration : "+duration+"Nano seconds");

        return result;
    }





@After("exceution(* com.AIThinkers.AOPDemo.DAO.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){

    //print out which method we are advising on
    String method= theJoinPoint.getSignature().toShortString();
    System.out.println("\n =====.>>>>> exceuting @After (finally)on method :"+ method);
    }



@AfterThrowing(
        pointcut = "exceution(* com.AIThinkers.AOPDemo.DAO.AccountDAO.findAccounts(..))",
        throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(
    JoinPoint theJoinPoint, Throwable theExc){
    //print out the which method we are advising on
    String method= theJoinPoint.getSignature().toShortString();
    System.out.println("\n =====.>>>>> exceuting @AfterThrowing on method :"+ method);

    //log  the Excepption
    System.out.println("\n =====.>>>>> The Exception is:"+ theExc);


    }



    //add a new advice for @AfterReturni8ng on the findAccounts method

    @AfterReturning(
            pointcut = "execution(* com.AIThinkers.AOPDemo.DAO.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint , List<Account> result){

        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n ====>>>>> Executing @AfterReturning on method : "+method);

        //print out the results of the method call
        System.out.println("\n =====>>>>> result is: "+result);


        //modify "result" list : add,remove,update
        //converting all the names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n =====>>>>> result is: "+result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        //loop through accounts
        for(Account account: result){
            //getuppercase version of names
            String theUpperName = account.getName().toUpperCase();

            //update the namess on the accounts
            account.setName(theUpperName);
        }


    }


    @Before("com.AIThinkers.AOPDemo.aspect.AopPointcutExpressions.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n ====>>>>> Exceuting @before advice on method");

        //display the method signature
        MethodSignature methodSignature=(MethodSignature) theJoinPoint.getSignature();

        System.out.println("method : "+methodSignature);

        //display method arguments

        //get args
        Object[] args = theJoinPoint.getArgs();
        //loop through the args
        for(Object tempArg : args){
            System.out.println(tempArg);

            if(tempArg instanceof Account){

                //downcast and print Account specific stuff

                Account theAccount = (Account) tempArg;

                System.out.println("account name :"+theAccount.getName());
                System.out.println("Account level :"+theAccount.getLevel());
            }
        }

    }


}
