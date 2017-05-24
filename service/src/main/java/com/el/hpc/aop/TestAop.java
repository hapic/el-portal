package com.el.hpc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ShenQi on 17/5/23.
 */

public class TestAop {



    public void excudeService(){
        System.out.println("TestAop.excudeService");
    }

//    @Around(value = "execution(* com.el.hpc.service.LandService.*(..))")
    public Object twiceAsOld(ProceedingJoinPoint thisJoinPoint){

        System.err.println ("切面执行了。。。。");
        try {
            Object proceed = thisJoinPoint.proceed();
            Object[] args = thisJoinPoint.getArgs();

            return proceed;
        } catch (Throwable e) {
            e.printStackTrace ();
        }
        return null;
    }
}
