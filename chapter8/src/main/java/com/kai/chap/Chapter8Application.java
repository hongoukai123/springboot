package com.kai.chap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;

@MapperScan(
        basePackages = "com.kai.chap",
        annotationClass = Repository.class
)
@SpringBootApplication(scanBasePackages = "com.kai.chap")
public class Chapter8Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter8Application.class, args);
    }

    //注入事务管理器，它由SpringBoot自动生成
    @Autowired
    PlatformTransactionManager transactionManager;

    /**
     * 使用初始化方法，观察自动生成的事务管理器
     */
    @PostConstruct
    public void viewTransactionManager(){
        //启动前加入断点观测
        System.out.println(transactionManager.getClass().getName());
    }

}
