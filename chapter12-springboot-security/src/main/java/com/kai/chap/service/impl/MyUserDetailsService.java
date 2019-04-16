package com.kai.chap.service.impl;

import com.kai.chap.mapper.IUserInfoMapper;
import com.kai.chap.mapper.IUserRoleMapper;
import com.kai.chap.pojo.po.UserInfo;
import com.kai.chap.pojo.po.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用Spring Security自定义认证服务
 * <p>
 *      SpringSecurity提供了一个UserDetailsService接口，通过它可以获取用户
 *      信息，而这个接口只有一个loadUserByUsername方法需要实现，这个方法返回
 *      UserDetails接口对象
 * </p>
 * @author hok
 * @since 2019-4-12 10:04:51
 */
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserInfoMapper userInfoMapper;
    @Autowired
    private IUserRoleMapper userRoleMapper;

    /**
     * 重写UserDetailsService中的方法
     * @param userName 用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //获取数据库用户信息
        UserInfo userInfo = userInfoMapper.getUserInfoByUserName(userName);
        //获取数据库角色信息
        List<UserRole> userRoleList = userRoleMapper.findUserRoleByUserName(userName);
        return changeToUser(userInfo, userRoleList);
    }

    private UserDetails changeToUser(UserInfo userInfo, List<UserRole> roleList){
        //权限列表
        List<GrantedAuthority> authorityList = new ArrayList<>();
        //赋予查询到的角色
        for (UserRole role : roleList) {
            GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
            authorityList.add(authority);
        }
        //创建UserDetails对象，设置用户名密码和权限
        UserDetails userDetails = new User(userInfo.getUserName(), userInfo.getPwd(), authorityList);
        return userDetails;
    }

}
