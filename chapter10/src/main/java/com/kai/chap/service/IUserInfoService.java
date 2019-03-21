package com.kai.chap.service;

import com.kai.chap.pojo.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * 用户业务接口
 * @author hok
 * @since 2019-3-20 17:19:19
 */
public interface IUserInfoService {

    /**
     * 获取单个用户
     * @param id
     * @return
     */
    UserInfo getUserInfoById(Integer id);

    /**
     * 添加用户
     * @param userInfo
     * @return
     */
    UserInfo insertUserInfo(UserInfo userInfo);

    /**
     * 修改用户
     * @param userInfo
     * @return
     */
    UserInfo updateUserInfo(Integer id, String userName, String note);

    /**
     * 查询用户列表
     * @param userName
     * @param note
     * @return
     */
    List<UserInfo> findUserInfos(Map<String, Object> maps);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteUserInfo(Integer id);

}
