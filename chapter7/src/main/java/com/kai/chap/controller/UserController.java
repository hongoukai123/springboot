package com.kai.chap.controller;

import com.kai.chap.pojo.User;
import com.kai.chap.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Integer id){
        return userService.selectUserById(id);
    }

}
