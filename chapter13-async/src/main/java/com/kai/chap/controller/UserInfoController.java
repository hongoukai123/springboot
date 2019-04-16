package com.kai.chap.controller;

import com.kai.chap.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;

    @GetMapping("/page")
    public String asyncPage(){
        System.out.println("请求线程名称：【" + Thread.currentThread().getName() + "】");
        userInfoService.generateReport();
        return "async";
    }

}
