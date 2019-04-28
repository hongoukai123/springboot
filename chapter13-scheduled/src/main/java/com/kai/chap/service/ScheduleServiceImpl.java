package com.kai.chap.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 设置定时任务业务实现类
 * @author hok
 * @since 2019-4-18 14:11:15
 */
@Service
public class ScheduleServiceImpl {

    //计数器
    int count1 = 1;
    int count2 = 2;

    /**
     * 任务一
     * <p>
     *     注解@Scheduled配置为按时间间隔执行，每隔一秒便执行一次。
     * </p>
     * <p>
     *     注解@Async表示，使用异步执行
     * </p>
     */
    @Scheduled(fixedRate = 1000)
    @Async
    public void job1(){
        System.out.println("【" + Thread.currentThread().getName() + "】" + "【job1每秒钟执行一次，执行第【" + count1 + "】次");
        count1++;
    }

    /**
     * 任务二
     * <p>
     *     注解@Scheduled配置为按时间间隔执行，每隔一秒便执行一次
     * </p>
     * <p>
     *     注解@Async表示，使用异步执行
     * </p>
     */
    @Scheduled(fixedRate = 1000)
    @Async
    public void job2(){
        System.out.println("【" + Thread.currentThread().getName() + "】" + "【job2每秒钟执行一次，执行第【" + count2 + "】次");
        count2++;
    }


}
