package com.kai.chap.service.impl;

import com.kai.chap.dao.IUserInfoDao;
import com.kai.chap.pojo.UserInfo;
import com.kai.chap.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户业务实现类
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private IUserInfoDao userInfoDao;

    /**
     * 添加用户信息
     * 方法带有@Transactional注解，说明此方法将启用Spring数据库事务机制
     * 其中isolation属性指定隔离级别，其中time
     * @param userInfo
     * @return
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
    @Override
    public int insertUserInfo(UserInfo userInfo) {
        return userInfoDao.insertUserInfo(userInfo);
    }

    /**
     * 批量添加用户信息
     * 属性propagation中的Propagation为数据库事务传播行为：REQUIRED，是默认传播行为，如果当前存在事务，
     * 就沿用当前事务，否则新建一个事务运行子方法
     * @param userInfoList
     * @return
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    @Override
    public int insertUserInfoList(List<UserInfo> userInfoList) {
        int count = 0;
        for (UserInfo userInfo : userInfoList){
            count += userInfoDao.insertUserInfo(userInfo);
        }
        return count;
    }
}
