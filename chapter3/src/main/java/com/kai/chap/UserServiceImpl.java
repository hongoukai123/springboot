package com.kai.chap;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void printUser(User user) {
        if(user == null){
            throw new RuntimeException("检查用户参数是否为空.......");
        }
        System.out.print("userName = " + user.getUserName());
        System.out.print("userAge = " + user.getUserAge());
        System.out.println("userAdd = " + user.getUserAdd());
    }

}
