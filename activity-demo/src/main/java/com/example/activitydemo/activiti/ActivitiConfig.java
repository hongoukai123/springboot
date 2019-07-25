package com.example.activitydemo.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 工作流配置类
 * @author hok
 * @since 2019-7-17 13:54:53
 */
@Configuration
public class ActivitiConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.activiti.database-schema-update}")
    private String schemaUpdate;

    /**
     * 获取流程引擎配置
     * @return
     */
    @Bean(name = "processEngineConfiguration")
    public ProcessEngineConfiguration findProcessEngineConfiguration(){
        ProcessEngineConfiguration processEngineConfiguration = new StandaloneProcessEngineConfiguration();
        processEngineConfiguration.setJdbcDriver(driver);
        processEngineConfiguration.setJdbcUrl(url);
        processEngineConfiguration.setJdbcUsername(username);
        processEngineConfiguration.setJdbcPassword(password);
        processEngineConfiguration.setDatabaseSchemaUpdate(schemaUpdate);
        return processEngineConfiguration;
    }

    /**
     * 创建流程引擎
     * <p>
     *     核心：注入到spring容器中
     * </p>
     * @param processEngineConfiguration
     * @return
     */
    @Bean(name = "processEngine")
    public ProcessEngine findProcessEngine(ProcessEngineConfiguration processEngineConfiguration){
        return processEngineConfiguration.buildProcessEngine();
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchemaUpdate() {
        return schemaUpdate;
    }

    public void setSchemaUpdate(String schemaUpdate) {
        this.schemaUpdate = schemaUpdate;
    }
}
