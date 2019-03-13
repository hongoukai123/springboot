package com.kai.chap;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void manyAspects() {
        System.out.println("测试多个切面。。。。");
    }

}
