package com.kai.chap.test;

import org.aopalliance.intercept.Invocation;

/**
 * 自定义拦截器实现类
 * @author hok
 * @since 2019-4-26 14:10:24
 */
public class MyInterception implements Interception {

    @Override
    public boolean before() {
        System.out.println("这里是MyInterception中的before方法。。。。。。");
        return true;
    }

    @Override
    public void after() {
        System.out.println("这里是MyInterception中的after方法。。。。。。");
    }

    @Override
    public Object around(Invocation invocation) throws Throwable {
        System.out.println("这里是MyInterception中的around方法。。。。。。前");
        //回调原有对象
        Object obj = invocation.proceed();
        System.out.println("这里是MyInterception中的around方法。。。。。。后");
        return obj;
    }

    @Override
    public void afterReturning() {
        System.out.println("这里是MyInterception中的afterReturning方法。。。。。。");
    }

    @Override
    public void afterThrowing() {
        System.out.println("这里是MyInterception中的afterThrowing方法。。。。。。");
    }

    @Override
    public boolean useAround() {
        return true;
    }

}
