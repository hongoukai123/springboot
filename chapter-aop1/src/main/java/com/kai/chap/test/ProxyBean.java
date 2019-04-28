package com.kai.chap.test;

import java.lang.reflect.*;
import org.aopalliance.intercept.Invocation;

/**
 * 代理bean类
 * <p>
 *     此类是将服务和拦截方器的方法植入约定的流程中，
 *     动态代理模式：增强或者控制对真实对象的访问；
 * </p>
 * @author hok
 * @since 2019-4-26 16:53:52
 */
public class ProxyBean implements InvocationHandler {

    private Object target;

    private Interception interception;

    /**
     * 绑定代理对象
     * @param target 被代理的对象
     * @param interception 自定义拦截器
     * @return
     */
    public static Object getProxyBean(Object target, Interception interception){
        ProxyBean proxyBean = new ProxyBean();
        //保存被代理的对象
        proxyBean.target = target;
        //保存拦截器
        proxyBean.interception = interception;
        //生成代理对象
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyBean);
        //返回代理对象
        return proxy;
    }

    /**
     * 代理对象方法逻辑
     * @param proxy 代理对象
     * @param method 当前方法
     * @param args 运行参数
     * @return 方法调用结果
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        //异常标识
        boolean exceptionFlag = false;
        Invocation invocation = new Invocation() {
            @Override
            public Object proceed() throws Throwable {
                return proxy;
            }

            @Override
            public Object getThis() {
                return target;
            }

            @Override
            public AccessibleObject getStaticPart() {
                return method;
            }

            @Override
            public Object[] getArguments() {
                return args;
            }
        };
        Object retObj = null;
        try {
            if (this.interception.before()){
                retObj = this.interception.around(invocation);
            } else {
                retObj = method.invoke(target, args);
            }
        } catch (Throwable e){
            //产生异常
            exceptionFlag = true;
        }
        this.interception.after();
        if (exceptionFlag){
            this.interception.afterThrowing();
        } else {
            this.interception.afterReturning();
            return retObj;
        }
        return null;
    }
}
