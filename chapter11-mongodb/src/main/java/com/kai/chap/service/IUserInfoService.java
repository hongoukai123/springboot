package com.kai.chap.service;

import com.kai.chap.pojo.UserInfo;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import java.util.List;

/**
 * 用户服务接口
 * @author hok
 * @since 2019-3-21 16:16:17
 */
public interface IUserInfoService {

    public void saveUser(UserInfo userInfo);

    public DeleteResult deleteUserInfo(Long id);

    public List<UserInfo> findUserInfo(String userName, String note, int skip, int limit);

    public UpdateResult updateUserInfo(Long id, String userName, String note);

    public UserInfo getUserInfo(Long id);

}
