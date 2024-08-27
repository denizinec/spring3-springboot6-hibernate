package com.deniz.aopdemo.aspect;

import com.deniz.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.deniz.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        // print out method we're advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====> Executing @Around on method: " + method);
        // get begin timestamp
        long begin = System.currentTimeMillis();
        // execute method
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception exc){

            // logging the exception

            System.out.println(exc.getMessage());

            // give user a custom message

            result = "Major accident! But no worries, your AOP is on its mission!";

        }
        // get end timestamp
        long end = System.currentTimeMillis();
        // compute duration and print
        long duration = end - begin;

        System.out.println("\n=====> Duration:  " + duration / 1000.0 + " seconds");

        return result;

    }

    @After("execution(* com.deniz.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====> Executing @After (finally) on method: " + method);

    }

    @AfterThrowing(
            pointcut = "execution(* com.deniz.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc){

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====> Executing @AfterThrowing on method: " + method);

        // log the exception

        System.out.println("\n=====> The exception is: " + theExc);

    }


    @AfterReturning(
            pointcut = "execution(* com.deniz.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====> Executing @AfterReturning on method: " + method);

        //  print out results of method call

        System.out.println("\n=====> Result is: " + result);

        // post-process data

        // converting the account names to uppercase
        oonvertAccountNamesUppercase(result);

        convertLevelsUppercase(result);

        System.out.println("\n=====> Modified result (uppercase name/level) is: " + result);


    }

    private void convertLevelsUppercase(List<Account> result) {

        for (Account tempAccount : result){
            String theUpperLevel = tempAccount.getLevel().toUpperCase();
            tempAccount.setLevel(theUpperLevel);
        }

    }

    private void oonvertAccountNamesUppercase(List<Account> result) {

        // loop through accounts

        for(Account tempAccount : result){

            // get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperName);

        }

    }


    @Before("com.deniz.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){

        System.out.println("======> Executing @Before advice on method");

        // display method signature

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        // display method arguments

        // get args
        Object[] args = joinPoint.getArgs();

        // loop through args

        for(Object tempArgs : args){

            System.out.println(tempArgs);

            if (tempArgs instanceof Account){

                // downcast and print Account specific elements

                Account account = (Account) tempArgs;
                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());

            }

        }


    }



}
