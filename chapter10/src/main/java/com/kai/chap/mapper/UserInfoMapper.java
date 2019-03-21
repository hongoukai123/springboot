package com.kai.chap.mapper;

import com.kai.chap.pojo.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 用户Mapper接口
 * @author hok
 * @since 2019-3-20 16:48:43
 */
@Repository
public interface UserInfoMapper {

    /**
     * 获取单个用户
     * @param id
     * @return
     */
    UserInfo getUserInfoById(Integer id);

    /**
     * 添加用户
     * @param userInfo
     * @return
     */
    int insertUserInfo(UserInfo userInfo);

    /**
     * 修改用户
     * @param userInfo
     * @return
     */
    int updateUserInfo(UserInfo userInfo);

    /**
     * 查询用户列表
     * @param userName
     * @param note
     * @return
     */
    List<UserInfo> findUserInfos(Map<String, Object> maps);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteUserInfo(Integer id);

}
