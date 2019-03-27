package com.kai.chap.controller;

import com.kai.chap.pojo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 获取请求头参数的控制器
 * @author hok
 * @since 2019-3-27 17:01:31
 */
@Controller
@RequestMapping("/test")
public class HeaderController {

    @GetMapping("/header/page")
    public String headerPage(){
        return "headerTest";
    }

    /**
     * 通过@RequestHeader接收请求头参数
     * @param id
     * @return
     */
    @GetMapping("/header/user")
    @ResponseBody
    public UserInfo headerUserInfo(@RequestHeader("id") Long id){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setUserName("王蛋");
        userInfo.setNote("wangdan");
        return userInfo;
    }

}
