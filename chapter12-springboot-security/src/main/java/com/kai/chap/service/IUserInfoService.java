package com.kai.chap.service;

import com.kai.chap.pojo.po.UserInfo;

/**
 * 用户业务接口
 * @author hok
 * @since 2019-4-9 15:47:59
 */
public interface IUserInfoService {

    UserInfo selectUserById(Long id);

}
