package com.kai.chap.controller;

import com.kai.chap.pojo.UserInfo;
import com.kai.chap.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户控制器
 * @author hok
 * @since 2019-3-14 14:27:26
 */
@Controller
@RequestMapping("user")
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;

    /**
     * 添加用户信息
     * @param userName
     * @param note
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Map<String, Object> insert(String userName, String note){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setNote(note);
        int result = userInfoService.insertUserInfo(userInfo);
        Map<String, Object> maps = new HashMap<>();
        maps.put("result", result);
        maps.put("userInfo", userInfo);
        return maps;
    }

    /**
     * 添加用户信息
     * @param userName
     * @param note
     * @return
     */
    @RequestMapping("/insertList")
    @ResponseBody
    public Map<String, Object> insertList(){
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUserName("test1");
        userInfo1.setNote("测试一");

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setUserName("test2");
        userInfo2.setNote("测试二");

        UserInfo userInfo3 = new UserInfo();
        userInfo3.setUserName("test3");
        userInfo3.setNote("测试三");

        UserInfo userInfo4 = new UserInfo();
        userInfo4.setUserName("test4");
        userInfo4.setNote("测试四");

        UserInfo userInfo5 = new UserInfo();
        userInfo5.setUserName("test5");
        userInfo5.setNote("测试五");
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(userInfo1);
        userInfoList.add(userInfo2);
        userInfoList.add(userInfo3);
        userInfoList.add(userInfo4);
        userInfoList.add(userInfo5);
        int result = userInfoService.insertUserInfoList(userInfoList);
        Map<String, Object> maps = new HashMap<>();
        maps.put("result", result);
        maps.put("userInfoList", userInfoList);
        return maps;
    }

}
