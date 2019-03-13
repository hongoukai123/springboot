package com.kai.chap;

import org.aspectj.lang.annotation.*;

/**
 * 解决MyAspect1中冗余的正则式
 */
@Aspect("myAspect1")
public class MyAspect1 {

    @Pointcut("execution(* com.kai.chap.UserServiceImpl.printUser(..))")
    public void pointCut(){
    }

    @Before("pointCut()")
    public void before(){
        System.out.println("这里是前置通知。。。。");
    }

//    @After("pointCut()")
//    public void after(){
//        System.out.println("这里是后置通知。。。。");
//    }
//
//    @AfterReturning("pointCut()")
//    public void afterReturning(){
//        System.out.println("这里是后置环绕通知。。。。");
//    }
//
//    @AfterThrowing("pointCut()")
//    public void afterThrowing(){
//        System.out.println("这里是后置异常通知。。。。");
//    }

}
