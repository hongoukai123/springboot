package com.kai.chap.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * 使用数据库自定义用户认证服务
 * @author hok
 * @since 2019-4-11 17:11:50
 */
//@Component
public class DataDBConfigurer extends WebSecurityConfigurerAdapter {

    //注入数据源
    @Autowired
    private DataSource dataSource;

    //注入配置的阴钥
    @Value("${system.user.password.secret}")
    private String secret = null;

    //使用用户名查询密码
    String pwdQuery = "select user_name, pwd, available from t_user_info where user_name = ?";

    //使用用户名查询角色信息
    String roleQuery = "select a.user_name, c.role_name " +
            "from t_user_info a,t_user_role b,t_role_info c " +
            "where a.id=b.user_id and b.role_id=c.id " +
            "and a.user_name = ?";

    /**
     * 不使用阴钥
     * 用来配置用户签名服务，主要是user-details机制，你还可以给用户赋予角色
     * @param auth 签名管理器构造器，用于构建用户具体权限控制
     * @throws Exception
     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //密码编码器
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        auth.jdbcAuthentication()
//            //密码编码器
//            .passwordEncoder(passwordEncoder)
//            //数据源
//            .dataSource(dataSource)
//            //查询用户，自动判断密码是否一致
//            .usersByUsernameQuery(pwdQuery)
//            //赋予权限
//            .authoritiesByUsernameQuery(roleQuery);
//    }

    /**
     * 使用阴钥（安全系数更高）
     * 用来配置用户签名服务，主要是user-details机制，你还可以给用户赋予角色
     * @param auth 签名管理器构造器，用于构建用户具体权限控制
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //密码编码器
        PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(this.secret);
        auth.jdbcAuthentication()
                //密码编码器
                .passwordEncoder(passwordEncoder)
                //数据源
                .dataSource(dataSource)
                //查询用户，自动判断密码是否一致
                .usersByUsernameQuery(pwdQuery)
                //赋予权限
                .authoritiesByUsernameQuery(roleQuery);
    }

}
