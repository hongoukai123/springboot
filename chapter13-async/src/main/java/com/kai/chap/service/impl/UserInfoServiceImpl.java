package com.kai.chap.service.impl;

import com.kai.chap.service.IUserInfoService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

    /**
     * 模拟生的成异步方法
     * <p>
     *     注解@Async声明使用异步调用
     * </p>
     */
    @Override
    @Async
    public void generateReport() {
        //打印线程名称
        System.out.println("报表线程名称【" + Thread.currentThread().getName() + "】");
    }

}
