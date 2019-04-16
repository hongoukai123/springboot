package com.kai.chap.service;

import com.kai.chap.pojo.UserInfo;

/**
 * 定义服务接口（ActiveMQ）
 * @author hok
 * @since 2019-4-12 16:38:16
 */
public interface IActiveMqService {

    /**
     * 发送消息(发送字符串类型消息)
     * @param message
     */
    public void sendMsg(String message);

    /**
     * 接收消息(接收字符串类型消息)
     * @param message
     */
    public void receiveMsg(String message);

    /**
     * 发送消息(发送对象类型消息)
     * @param userInfo
     */
    public void sendUserInfo(UserInfo userInfo);

    /**
     * 接收消息(接收对象类型消息)
     * @param userInfo
     */
    public void receiveUserInfo(UserInfo userInfo);

}
