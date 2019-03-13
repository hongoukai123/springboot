package com.kai.chap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@SpringBootApplication          //Springboot自动装配
public class Chapter1Application {

    @RequestMapping("/test")
    @ResponseBody
    public Map<String, String> test(){
        Map<String, String> maps = new HashMap<>();
        maps.put("Hello", "World");
        return maps;
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter1Application.class, args);
    }

}
