package com.kai.chap.service.impl;

import com.kai.chap.dao.IUserDao;
import com.kai.chap.pojo.User;
import com.kai.chap.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现类
 * @author hok
 * @since 2019-3-13 16:54:37
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User selectUserById(Integer id) {
        return userDao.selectUserById(id);
    }

}
