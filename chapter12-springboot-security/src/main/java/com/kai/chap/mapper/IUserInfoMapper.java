package com.kai.chap.mapper;

import com.kai.chap.pojo.po.UserInfo;

/**
 * 用户数据访问接口
 * @author hok
 * @since 2019-4-9 15:48:29
 */
public interface IUserInfoMapper {

    /**
     * 根据id获取用户对象
     * @param id id
     * @return
     */
    UserInfo selectUserById(Long id);

    /**
     * 根据用户名获取用户对象
     * @param userName 用户名
     * @return
     */
    UserInfo getUserInfoByUserName(String userName);

}
