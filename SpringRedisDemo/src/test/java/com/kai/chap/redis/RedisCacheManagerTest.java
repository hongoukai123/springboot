package com.kai.chap.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:redis-config.xml")
public class RedisCacheManagerTest {

//    @Autowired
//    private RedisCacheManager redisCacheManager;
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedisSet(){
//        boolean bo = redisCacheManager.set("name", "杰克");
//        if (bo){
//            String userName = redisCacheManager.get("name").toString();
//            System.out.println(userName);
//        }
//        System.out.println("存入redis失败");

        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("wang", "王铭");
        System.out.println(valueOperations.get("wang"));
    }

}
