package com.kai.chap.dao;

import com.kai.chap.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {

    User selectUserById(Integer id);

}
