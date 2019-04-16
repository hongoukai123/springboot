package com.kai.chap.controller;

import com.kai.chap.pojo.po.UserInfo;
import com.kai.chap.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;

    @RequestMapping("find")
    @ResponseBody
    public UserInfo getUserInfo(){
        UserInfo userInfo = userInfoService.selectUserById(1L);
        return userInfo;
    }

}
