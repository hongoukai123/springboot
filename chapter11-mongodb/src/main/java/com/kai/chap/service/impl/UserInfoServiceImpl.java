package com.kai.chap.service.impl;

import com.kai.chap.pojo.UserInfo;
import com.kai.chap.service.IUserInfoService;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务实现类
 * @author hok
 * @since 2019-3-21 16:22:29
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

    /**
     * 注入MongoTemplate对象
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUser(UserInfo userInfo) {
        //使用名称userInfo文档保存用户信息
        mongoTemplate.save(userInfo);
    }

    @Override
    public DeleteResult deleteUserInfo(Long id) {
        return null;
    }

    @Override
    public List<UserInfo> findUserInfo(String userName, String note, int skip, int limit) {
        //将用户名称和备注设置为模糊查询准则
        Criteria criteria = Criteria.where("userName").regex(userName).and("note").regex(note);
        //构建查询条件，并设置分页跳过钱skip个，至多返回limit个
        Query query = Query.query(criteria).limit(limit).skip(skip);
        //执行
        List<UserInfo> userInfoList = mongoTemplate.find(query, UserInfo.class);
        return userInfoList;
    }

    @Override
    public UpdateResult updateUserInfo(Long id, String userName, String note) {
        return null;
    }

    @Override
    public UserInfo getUserInfo(Long id) {
        return mongoTemplate.findById(id, UserInfo.class);
    }

}
