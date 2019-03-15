package com.kai.chap.service;

import com.kai.chap.pojo.UserInfo;

import java.util.List;

/**
 * 用户业务接口
 * @author hok
 * @since 2019-3-14 14:21:17
 */
public interface IUserInfoService {

    /**
     * 添加用户信息
     * @param userInfo
     * @return
     */
    int insertUserInfo(UserInfo userInfo);

    /**
     * 批量添加用户信息
     * @param userInfoList
     * @return
     */
    int insertUserInfoList(List<UserInfo> userInfoList);

}
