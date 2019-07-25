package com.example.activitydemo.service;

/**
 * 资源审核业务接口
 * @author hok
 * @since 2019-7-17 17:07:02
 */
public interface IActivitiService {

    /**
     * 启动资源审核流程
     * @param bizId 流程图ID
     * @param userType 用户类型
     * @return
     */
    boolean startProcesses(String bizId, String userType);



}
