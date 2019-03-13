package com.kai.chap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.kai.chap")
public class Chapter5Application {

//    @Bean(name = "datasourceShow")
//    public DataSourceShow initShow(){
//        return new DataSourceShow();
//    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter5Application.class, args);
    }

}
