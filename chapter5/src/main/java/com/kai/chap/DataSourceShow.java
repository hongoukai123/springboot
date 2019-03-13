package com.kai.chap;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * 检测数据库连接池类型
 * <p>
 *     此类实现Spring bean生命周期接口ApplicationContextAware
 * </p>
 * @author hok
 * @since 2019-3-11 11:07:27
 */
@Component
public class DataSourceShow implements ApplicationContextAware {

    ApplicationContext applicationContext = null;

    /**
     * spring容器会自动调用这个方法，注入到Spring IOC容器中
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println("--------------------------------");
        System.out.println(dataSource.getClass().getName());
        System.out.println("--------------------------------");
    }
}
