package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

//@Aspect
//@Component
public class ParameterAOP {
    //@Pointcut("execution(* com.example.aop.controller..*.*(..))")
    public void cut() {

    }

    //@Before("cut()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        for(Object obj : args) {
            System.out.println("Type : " + obj.getClass().getSimpleName());
            System.out.println("Value : " + obj);
        }
    }

    //@AfterReturning(value = "cut()", returning = "returnobj")
    public void afterReturn(JoinPoint joinPoint, Object returnobj) {
        System.out.println("Return Object!");
        System.out.println(returnobj);
    }

}
