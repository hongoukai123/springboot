package com.kai.chap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器
 * 用来呈现拦截器效果
 * @author hok
 * @since 2019-3-26 10:07:16
 */
@Controller
@RequestMapping("/interceptor")
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        System.out.println("执行处理器逻辑（控制器的index()方法）");
        return "index";
    }

}
