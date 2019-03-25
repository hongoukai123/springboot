package com.kai.chap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.kai.chap")
public class Chapter11MongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chapter11MongodbApplication.class, args);
    }

}
