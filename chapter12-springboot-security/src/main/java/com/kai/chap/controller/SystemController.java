package com.kai.chap.controller;

import com.kai.chap.pojo.po.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统控制器
 * @author hok
 * @since 2019-4-12 13:58:55
 */
@Controller
@RequestMapping("system")
public class SystemController {

    @PostMapping("/login")
    public String login(@RequestBody UserInfo userInfo){
        return "index";
    }

    @PostMapping("/logout")
    public String logout(){
        return "index";
    }

}
