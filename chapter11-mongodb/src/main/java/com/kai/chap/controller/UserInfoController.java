package com.kai.chap.controller;

import com.kai.chap.pojo.UserInfo;
import com.kai.chap.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户控制器
 * 测试操作MongoDB
 * @author hok
 * @since 2019-3-21 17:13:10
 */
@RestController
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;

    /**
     * 获取用户列表，并且分页
     * @param userName 用户名称
     * @param note 备注
     * @param skip 跳过用户个数
     * @param limit 限制返回用户个数
     * @return
     */
    @RequestMapping("/list")
    public List<UserInfo> findUsers(String userName, String note, Integer skip, Integer limit){
        List<UserInfo> userInfoList = userInfoService.findUserInfo(userName, note, skip, limit);
        return userInfoList;
    }

    /**
     * 添加用户信息到MongoDB中
     * @param userInfo
     * @return
     */
    @RequestMapping("/save")
    public UserInfo saveUserInfo(UserInfo userInfo){
        userInfoService.saveUser(userInfo);
        return userInfo;
    }

}
