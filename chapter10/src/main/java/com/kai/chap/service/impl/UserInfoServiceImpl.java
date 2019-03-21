package com.kai.chap.service.impl;

import com.kai.chap.mapper.UserInfoMapper;
import com.kai.chap.pojo.UserInfo;
import com.kai.chap.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 用户业务实现类
 * 其中的Cacheable后面的value属性指向的是application.properties中配置的
 * @author hok
 * @since 2019-3-20 17:54:57
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 根据id获取用户对象
     *  获取id，取参数id缓存用户（redis缓存）
     * @param id
     * @return
     */
    @Override
    @Transactional
    @Cacheable(value = "redisCache", key = "'redis_user_' + #id")
    public UserInfo getUserInfoById(Integer id) {
        return userInfoMapper.getUserInfoById(id);
    }

    /**
     * 添加用户
     * 取结果id缓存用户
     * @param userInfo
     * @return
     */
    @Override
    @Transactional
    @CachePut(value = "redisCache", key = "'redis_user_' + #result.id")
    public UserInfo insertUserInfo(UserInfo userInfo) {
        userInfoMapper.insertUserInfo(userInfo);
        return userInfo;
    }

    /**
     * 更新数据更新缓存
     * 如果condition配置项使结果返回为null,不缓存
     * @param userInfo
     * @return
     */
    @Override
    @Transactional
    @CachePut(value = "redisCache", condition = "#result != 'null'", key = "'redis_user_' + #id")
    public UserInfo updateUserInfo(Integer id, String userName, String note) {
        UserInfo userInfo = getUserInfoById(id);
        if (userInfo == null) return null;
        if(userName != null || !userName.equals("")){
            userInfo.setUserName(userName);
        }
        if (note != null || !note.equals("")){
            userInfo.setNote(note);
        }
        userInfoMapper.updateUserInfo(userInfo);
        return userInfo;
    }

    /**
     * 获取用户集合
     * 不采用缓存机制
     * @param maps
     * @return
     */
    @Override
    @Transactional
    public List<UserInfo> findUserInfos(Map<String, Object> maps) {
        return userInfoMapper.findUserInfos(maps);
    }

    /**
     * 删除用户
     * 移除缓存
     * beforeInvocation中的false为默认，默认为方法之后将缓存移除
     * @param id
     * @return
     */
    @Override
    @Transactional
    @CacheEvict(value = "redisCache",key = "'redis_user_' + #id", beforeInvocation = false)
    public int deleteUserInfo(Integer id) {
        return userInfoMapper.deleteUserInfo(id);
    }
}
