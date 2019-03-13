package com.kai.chap.service;

import com.kai.chap.pojo.User;

import java.util.List;

public interface JdbcTmplUserService {

    public User getUser(Long id);

    public List<User> findUsers(String userName, String note);

    public int insertUser(User user);

    public int updateUser(User user);

    public int deleteUser(Long id);

}
