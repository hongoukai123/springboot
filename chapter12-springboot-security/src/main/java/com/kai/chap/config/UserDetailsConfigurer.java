package com.kai.chap.config;

import com.kai.chap.service.impl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 使用用户自定义认证服务
 * @author hok
 * @since 2019-4-12 10:43:58
 */
//@Component
public class UserDetailsConfigurer extends WebSecurityConfigurerAdapter {

    //拿到配置文件设置的阴钥
    @Value("${system.user.password.secret}")
    private String secret = null;

    @Autowired
    private MyUserDetailsService userDetailsService;

    /**
     * 使用阴钥（安全系数更高）
     * 用来配置用户签名服务，主要是user-details机制，你还可以给予用户赋予角色
     * @param auth 签名管理器构造器，用于构建用户具体权限控制
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //密码编码器
        PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(this.secret);
        //设置用户密码服务和密码编码器
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder);
    }

}
