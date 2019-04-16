package com.kai.chap.controller;

import com.kai.chap.pojo.UserInfo;
import com.kai.chap.service.IActiveMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试ActiveMQ控制器
 * @author hok
 * @since 2019-4-15 11:04:21
 */
@Controller
@RequestMapping("activemq")
public class ActiveMqController {

    @Autowired
    private IActiveMqService activeMqService;

    /**
     * 测试普通消息的发送
     * @param message
     * @return
     */
    @ResponseBody
    @GetMapping("msg")
    public Map<String, Object> msg(String message){
        activeMqService.sendMsg(message);
        return result(true, message);
    }

    /**
     * 测试对象的发送
     * @param id
     * @param userName
     * @param note
     * @return
     */
    @ResponseBody
    @GetMapping("user")
    public Map<String, Object> sendUserInfo(Long id, String userName, String note){
        UserInfo userInfo = new UserInfo(id, userName, note);
        activeMqService.sendUserInfo(userInfo);
        return result(true, userInfo);
    }

    private Map<String, Object> result(Boolean success, Object message){
        Map<String, Object> map = new HashMap<>();
        map.put("success", success);
        map.put("message", message);
        return map;
    }

}
