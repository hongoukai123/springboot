package com.kai.chap;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect3 {


    @Pointcut("execution(* com.kai.chap.UserServiceImpl.manyAspects(..))")
    public void manyAspects() {

    }

//    @Before("manyAspects()")
//    public void before(){
//        System.out.println("这里是MyAspect3的前置通知。。。。");
//    }
//
//    @After("manyAspects()")
//    public void after(){
//        System.out.println("这里是MyAspect3的后置通知。。。。");
//    }

    @Around("manyAspects()")
    public void proceedingJoinPoint(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("MyAspect3的环绕通知，前方执行。。。");
        pjp.proceed();
        System.out.println("MyAspect3的环绕通知，后方执行。。。");
    }

}
