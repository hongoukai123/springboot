package com.kai.chap;

import com.kai.chap.service.IJdbcService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter8ApplicationTests {

    @Autowired
    private IJdbcService jdbcService;

    /**
     * 测试jdbc底层实现事务
     */
    @Test
    public void contextLoads() {
        int num = jdbcService.insertUser("lisa", "丽萨");
        System.out.println(num);

    }

}
