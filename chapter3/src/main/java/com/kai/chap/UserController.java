package com.kai.chap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    //注入用户服务
    @Autowired
    private UserService userService;

    @RequestMapping("/print")
    @ResponseBody
    public User printUser(){
        User user = new User();
        user.setUserName("Jack");
        user.setUserAge(20);
        user.setUserAdd("广东深圳");
        userService.printUser(user);
        return user;
    }

}
