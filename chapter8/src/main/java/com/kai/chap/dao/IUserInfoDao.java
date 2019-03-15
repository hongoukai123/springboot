package com.kai.chap.dao;

import com.kai.chap.pojo.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * 用户信息DAO接口
 * @author hok
 * @since 2019-3-14 14:14:38
 */
@Repository
public interface IUserInfoDao {

    /**
     * 添加用户信息
     * @param userInfo
     * @return
     */
    int insertUserInfo(UserInfo userInfo);

}
