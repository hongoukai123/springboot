package com.kai.chap.controller;

import com.kai.chap.pojo.UserInfo;
import com.kai.chap.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户控制器
 * @author hok
 * @since 2019-3-21 09:52:31
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;

    @RequestMapping("/getUser")
    public UserInfo getUserInfoById(Integer id){
        return userInfoService.getUserInfoById(id);
    }

    @RequestMapping("/insert")
    public UserInfo insertUserInfo(String userName, String note){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setNote(note);
        userInfoService.insertUserInfo(userInfo);
        return userInfo;
    }

    @RequestMapping("/list")
    public List<UserInfo> findUserInfos(String userName, String note){
        Map<String, Object> maps = new HashMap<>();
        maps.put("userName", userName);
        maps.put("note", note);
        return userInfoService.findUserInfos(maps);
    }

    @RequestMapping("/update")
    public Map<String, Object> updateUserInfo(Integer id, String userName, String note){
        UserInfo userInfo = userInfoService.updateUserInfo(id, userName, note);
        boolean flag = userInfo != null;
        String message = flag ? "更新成功" : "更新失败";
        return resultMap(flag, message);
    }

    @RequestMapping("/delete")
    public Map<String, Object> deleteUserInfo(Integer id){
        int result = userInfoService.deleteUserInfo(id);
        boolean flag = result == 1;
        String message = flag ? "删除成功" : "删除失败";
        return resultMap(flag, message);
    }

    /**
     * 结果集
     * @param success
     * @param message
     * @return
     */
    private Map<String, Object> resultMap(boolean success, String message){
        Map<String, Object> map = new HashMap<>();
        map.put("success", success);
        map.put("message", message);
        return map;
    }

}
