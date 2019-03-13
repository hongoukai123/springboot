package com.kai.chap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//定义Spring Boot扫描包路径
@SpringBootApplication(scanBasePackages = "com.kai.chap")
//定义jap接口扫描包路径(如果不写也行， 只要有spring-boot-starter-data-jpa包，在springboot2.x环境下都会被自动扫描到)
@EnableJpaRepositories(basePackages = "com.kai.chap.dao")
//定义Bean扫描包路径(如果不写也行， 只要有spring-boot-starter-data-jpa包，在springboot2.x环境下都会被自动扫描到)
@EntityScan(basePackages = "com.kai.chap.pojo")
public class Chapter6Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter6Application.class, args);
    }

}
