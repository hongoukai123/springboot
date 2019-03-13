package com.kai.chap;

import com.kai.chap.enumeration.SexEnum;
import com.kai.chap.pojo.User;
import com.kai.chap.service.JdbcTmplUserService;
import com.kai.chap.service.impl.JdbcTmplUserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter5ApplicationTests {

    @Autowired
    private JdbcTmplUserService userService;

    @Test
    public void contextLoads() {
//        User user = new User();
//        user.setUserName("jack");
//        SexEnum sex = SexEnum.getEnumById(1);
//        user.setSex(sex);
//        user.setNote("杰克");
//        int num = userService.insertUser(user);
        User user = userService.getUser(1L);
        System.out.println("添加用户数据执行结果：" + user.getUserName());
    }

}
