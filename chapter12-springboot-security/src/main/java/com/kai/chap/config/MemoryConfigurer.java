package com.kai.chap.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 使用内存签名服务
 * <p>
 *     使用内存缓存用户信息这样的方式不是主要的方式，
 *     因为内存空间毕竟有限，而且会占用JVM的内存空间。
 *     在项目上线发布时不推荐使用此方式。
 * </p>
 * @author hok
 * @since 2019-4-11 16:32:04
 */
@Component
public class MemoryConfigurer extends WebSecurityConfigurerAdapter {

    /**
     * 第一种繁琐的配置
     * 用来配置用户签名服务，主要是user-details机制，你还可以给予用户赋予角色
     * @param auth 签名管理器构造器，用于构建用户具体权限控制
     * @throws Exception
     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //密码编码器
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        //使用内存存储
//        auth.inMemoryAuthentication()
//            //设置密码编码器
//            .passwordEncoder(passwordEncoder)
//            //注册用户admin,密码为abc,并赋予USER和ADMIN的角色权限
//            .withUser("admin")
//                //可通过passwordEncoder.encode("abc")得到加密后的密码
//                .password(passwordEncoder.encode("abc"))
//                .roles("USER", "ADMIN")
//            //连接方法and
//            .and()
//            //注册用户myuser,密码为123456,并赋予USER的角色权限
//            .withUser("myuser")
//                //可通过passwordEncoder.encode("123456")得到加密后的密码
//                .password(passwordEncoder.encode("123456"))
//                .roles("USER");
//    }

    /**
     * 第二种精简版（解决第一种比较冗余的and连接操作）
     * 用来配置用户签名服务，主要是user-details机制，你还可以给予用户赋予角色
     * @param auth 签名管理器构造器，用于构建用户具体权限控制
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //密码编码器
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //使用内存存储
        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> userConfig
                = auth.inMemoryAuthentication()
                    //设置密码编码器
                    .passwordEncoder(passwordEncoder);
        //注册用户admin,密码为abc,并赋予USER和ADMIN的角色权限
        userConfig.withUser("admin")
            //可通过passwordEncoder.encode("abc")得到加密后的密码
            .password(passwordEncoder.encode("abc"))
            .authorities("ROLE_USER", "ROLE_ADMIN");
        //注册用户myuser,密码为123456,并赋予USER的角色权限
        userConfig.withUser("myuser")
            //可通过passwordEncoder.encode("123456")得到加密后的密码
            .password(passwordEncoder.encode("123456"))
            .authorities("ROLE_USER");
    }

    /**
     * 用来配置拦截保护的请求，比如什么请求放行，什么请求需要验证
     * @param http http安全请求对象
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            //访问/resource下的请求需要管理员权限
            .authorizeRequests().antMatchers("/resource/**")
                .access("hasRole('ADMIN')")
            //通过签名后可以访问任何请求
            .and().authorizeRequests().antMatchers("/**").permitAll()
            //设置登录页和默认的跳转路径
            .and().formLogin().loginPage("/system/login")
                .defaultSuccessUrl("/index/list")
            //登出页面和默认跳转路径
            .and().logout().logoutUrl("/system/logout")
                .logoutSuccessUrl("/index/list");
    }

}
