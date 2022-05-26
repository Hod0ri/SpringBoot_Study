package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAOP {
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    public void cut() {}


    @Pointcut("@annotation(com.example.aop.annotation.Timer)")
    private void EnableTimer() {

    }

    @Around("cut() && EnableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();

        System.out.println("Total Time : " + stopWatch.getTotalTimeSeconds());
    }
}
