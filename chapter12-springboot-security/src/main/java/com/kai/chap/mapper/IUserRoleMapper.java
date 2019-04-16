package com.kai.chap.mapper;

import com.kai.chap.pojo.po.UserRole;

import java.util.List;

/**
 * 用户角色数据访问接口
 * @author hok
 * @since 2019-4-12 10:21:08
 */
public interface IUserRoleMapper {

    /**
     * 根据用户名获取用户角色信息
     * @param userName 用户名
     * @return
     */
    List<UserRole> findUserRoleByUserName(String userName);

}
