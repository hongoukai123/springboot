package com.kai.chap;

import com.kai.chap.dao.IUserDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

//第三种：使用@MapperScan定义扫描
@MapperScan(
        //指定扫描包
        basePackages = "com.kai.chap.*",
        //指定SqlSessionFactory,如果SqlSessionTemplate被指定，则作废（如果多个SqlSessionFactory则必须指定）
        sqlSessionFactoryRef = "sqlSessionFactory",
        //指定sqlSessionTemplate,将忽略SqlSessionFactory的配置
        sqlSessionTemplateRef = "sqlSessionTemplate",
        //限定扫描接口
        annotationClass = Repository.class
)
@SpringBootApplication
public class Chapter7Application {

    /*第一种方式：使用MapperFactoryBean方式装配MyBatis接口
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Bean
    public MapperFactoryBean<IUserDao> initIUserDao(){
        MapperFactoryBean<IUserDao> bean = new MapperFactoryBean<>();
        bean.setMapperInterface(IUserDao.class);
        bean.setSqlSessionFactory(sqlSessionFactory);
        return bean;
    }*/


    /**
     * 第二种：使用MapperScannerConfigur扫描装配MyBatis接口
     * @return
     */
   /* @Bean
    public MapperScannerConfigurer mapperScannerConfig(){
        //定义扫描器实例
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        //加载SqlSessionFactory,Spring Boot会自动产生，SqlSessionFactory实例
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        //定义扫描包
        configurer.setBasePackage("com.kai.chap.*");
        //限定被标注的@Repository的接口才被扫描
        configurer.setAnnotationClass(Repository.class);
        return configurer;
    }*/

    public static void main(String[] args) {
        SpringApplication.run(Chapter7Application.class, args);
    }

}
