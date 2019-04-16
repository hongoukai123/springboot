package com.kai.chap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.kai.chap")
@MapperScan(basePackages = "com.kai.chap")
public class Chapter12SpringbootSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chapter12SpringbootSecurityApplication.class, args);
    }

}
