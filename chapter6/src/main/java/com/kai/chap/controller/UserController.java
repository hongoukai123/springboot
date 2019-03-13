package com.kai.chap.controller;

import com.kai.chap.dao.UserDao;
import com.kai.chap.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long id){
        //调用jap接口查询对象
        User user = userDao.findById(id).get();
        return user;
    }

    @RequestMapping("/findLike")
    @ResponseBody
    public List<User> findByUserNameLike(String userName){
        List<User> userList = userDao.findByUserNameLike("%" + userName + "%");
        return userList;
    }

}
