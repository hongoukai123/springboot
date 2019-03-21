package com.kai.chap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = "com.kai.chap")
@MapperScan(basePackages = "com.kai.chap", annotationClass = Repository.class)
@EnableCaching  //驱动Spring缓存工作
public class Chapter10Application {

    @Autowired
    private RedisConnectionFactory connectionFactory;

    @Autowired
    private RedisTemplate redisTemplate;

    //自定义初始化
    @PostConstruct
    public void init(){
        initRedisTemplate();
    }

    //改变RedisTemplate对键的序列化策略
    public void initRedisTemplate(){
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
    }


    public static void main(String[] args) {
        SpringApplication.run(Chapter10Application.class, args);
    }

}
