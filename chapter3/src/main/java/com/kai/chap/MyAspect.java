package com.kai.chap;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect {

    /**
     * 前置通知
     */
//    @Before("execution(* com.kai.chap.UserServiceImpl.printUser(..))")
//    public void before(){
//        System.out.println("这里是前置通知。。。。。");
//    }

    /**
     * 后置通知
     */
//    @After("execution(* com.kai.chap.UserServiceImpl.printUser(..))")
//    public void after(){
//        System.out.println("这里是后置通知。。。。。");
//    }

    /**
     * 后置环绕通知
     */
//    @AfterReturning("execution(* com.kai.chap.UserServiceImpl.printUser(..))")
//    public void afterReturning(){
//        System.out.println("这里是后置环绕通知。。。。。");
//    }

    /**
     * 这里是后置异常通知
     */
//    @AfterThrowing("execution(* com.kai.chap.UserServiceImpl.printUser(..))")
//    public void afterThrowing(){
//        System.out.println("这里是后置异常通知。。。。。");
//    }

    @Around("execution(* com.kai.chap.UserServiceImpl.printUser(..))")
    public void around(ProceedingJoinPoint pjp)throws Throwable{
        System.out.println("环绕通知，通知在切点前方。。。。");
        //回调目标对象的原有方法
        pjp.proceed();
        System.out.println("环绕通知，通知在切点后方。。。。");
    }

}
