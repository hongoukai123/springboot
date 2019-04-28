package com.kai.chap;

import com.kai.chap.test.HelloService;
import com.kai.chap.test.HelloServiceImpl;
import com.kai.chap.test.MyInterception;
import com.kai.chap.test.ProxyBean;

public class Test {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        //按照约定获取proxy
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterception());
//        proxy.sayHello("杰克");
        proxy.sayHello("");
    }

}
