package com.kai.chap.service.impl;

import com.kai.chap.mapper.IUserInfoMapper;
import com.kai.chap.pojo.po.UserInfo;
import com.kai.chap.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现类
 * @author hok
 * @since 2019-4-4 17:09:39
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private IUserInfoMapper userInfoMapper;

    @Override
    public UserInfo selectUserById(Long id) {
        return userInfoMapper.selectUserById(id);
    }
}
