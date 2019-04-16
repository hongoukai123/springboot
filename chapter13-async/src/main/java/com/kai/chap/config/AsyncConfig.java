package com.kai.chap.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 线程池和启用异步
 * <p>
 *     注解@EnableAsync代表开启了Spring异步。
 *     这样就可以使用@Async驱动Spring使用异步，
 *     但是异步需要提供可用线程池，所以这个配置
 *     类必须实现AsyncConfigurer接口，然后覆盖getAsyncExecutor方法。
 *     这样就可以定义一个线程池。
 * </p>
 * @author hok
 * @since 2019-4-12 14:34:29
 */
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    /**
     * 获取线程池
     * @return
     */
    @Override
    public Executor getAsyncExecutor() {
        //定义线程池
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //核心线程数
        taskExecutor.setCorePoolSize(10);
        //线程池最大线程数
        taskExecutor.setMaxPoolSize(30);
        //线程队列最大线程数
        taskExecutor.setQueueCapacity(2000);
        //初始化
        taskExecutor.initialize();
        return taskExecutor;
    }

}
