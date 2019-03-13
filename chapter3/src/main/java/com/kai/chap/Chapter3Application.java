package com.kai.chap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Chapter3Application {

    //定义切面
    @Bean(name = "myAspect")
    public MyAspect initMyAspect(){
        return new MyAspect();
    }

    //定义切面
    @Bean(name = "myAspect1")
    public MyAspect1 initMyAspect1(){
        return new MyAspect1();
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter3Application.class, args);
    }

}
