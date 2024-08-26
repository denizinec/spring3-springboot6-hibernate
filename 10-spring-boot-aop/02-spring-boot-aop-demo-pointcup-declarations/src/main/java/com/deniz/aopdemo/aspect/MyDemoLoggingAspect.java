package com.deniz.aopdemo.aspect;

import com.deniz.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @AfterReturning(
            pointcut = "(* com.deniz.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
            String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====> Executing @AfterReturning on method: " + method);

        //  print out results of method call

        System.out.println("\n=====> Result is: " + result);



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
