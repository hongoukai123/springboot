package com.kai.chap.test;

public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        if(name == null || name.trim() == ""){
            throw new RuntimeException("参数为空");
        }
        System.out.println("hello " + name);
    }

}
