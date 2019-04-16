package com.kai.chap.service.impl;

import com.kai.chap.pojo.UserInfo;
import com.kai.chap.service.IActiveMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * 服务接口实现类（ActiveMQ）
 * @author hok
 * @since 2019-4-12 16:41:06
 */
@Service("activeMqService")
public class ActiveMqServiceImpl implements IActiveMqService {

    /**
     * 注入由SpringBoot自动产生的jmsTemplate
     */
    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 自定义地址
     */
    private static final String myDestination = "my-destination";

    @Override
    public void sendMsg(String message) {
        System.out.println("发送消息【" + message + "】");
        //自定义发送地址
        jmsTemplate.convertAndSend("your-destination", message);
    }

    @Override
    //使用注解监听地址发送过来的信息
    @JmsListener(destination = "${spring.jms.template.default-destination}")
    public void receiveMsg(String message) {
        System.out.println("接收到的信息：【" + message + "】");
    }

    @Override
    public void sendUserInfo(UserInfo userInfo) {
        System.out.println("发送消息【"+ userInfo +"】");
        //使用自定义地址发送对象
        jmsTemplate.convertAndSend(myDestination, userInfo);
    }

    @Override
    //监控自定义地址
    @JmsListener(destination = myDestination)
    public void receiveUserInfo(UserInfo userInfo) {
        System.out.println("接收到消息：【" + userInfo + "】");
    }

}
