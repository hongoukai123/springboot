package com.kai.chap.service;

import com.kai.chap.pojo.User;

/**
 * 用户业务接口
 * @author hok
 * @since 2019-3-13 16:53:25
 */
public interface IUserService {

    User selectUserById(Integer id);

}
