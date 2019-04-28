package com.kai.chap.redis;

import com.kai.chap.pojo.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试spring-data-redis缓存
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:redis-config.xml")
public class RedisCacheManagerTest {

   @Autowired
   private RedisCacheManager redisCacheManager;

    /**
     * 测试String存取
     */
    @Test
    public void testRedisSet(){
        redisCacheManager.set("yidu","异度云教育");
        System.out.println(redisCacheManager.get("yidu"));
    }

    /**
     * 测试List集合存取
     */
    @Test
    public void testRedisList(){
        List<UserInfo> userList = new ArrayList<UserInfo>();
        UserInfo u1 = new UserInfo();
        u1.setId(1);
        u1.setUserName("张三");
        u1.setAge(20);
        userList.add(u1);
        UserInfo u2 = new UserInfo();
        u2.setId(2);
        u2.setUserName("李四");
        u2.setAge(30);
        userList.add(u2);
        UserInfo u3 = new UserInfo();
        u3.setId(3);
        u3.setUserName("王麻子");
        u3.setAge(40);
        userList.add(u3);
        redisCacheManager.lSet("userList", userList);
        List<Object> userInfoList = redisCacheManager.lGet("userList", 0, 0);
        for (Object obj : userInfoList){
            System.out.println(obj);
        }
    }

}
