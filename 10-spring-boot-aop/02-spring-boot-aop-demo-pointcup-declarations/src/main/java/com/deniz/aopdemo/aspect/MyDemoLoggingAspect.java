package com.deniz.aopdemo.aspect;

import com.deniz.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


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
