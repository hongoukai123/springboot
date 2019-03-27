package com.kai.chap;

import com.kai.chap.interceptor.Interceptor1;
import com.kai.chap.interceptor.Interceptor2;
import com.kai.chap.interceptor.Interceptor3;
import com.kai.chap.interceptor.MyInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  //声明为Spring配置类
@SpringBootApplication(scanBasePackages = "com.kai.chap")
public class Chapter12InterceptorApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(Chapter12InterceptorApplication.class, args);
    }

    /**
     * 测试注册单个拦截器操作
     * <p>
     *     单个拦截器执行顺序：
     *     1.执行处理器前的方法（自定义创建的拦截器中重写HandlerInterceptor中的方法（preHandle））
     *     2.执行处理器逻辑方法（控制器（controller）中的方法）
     *     3.执行处理器后的方法（自定义创建的拦截器中重写HandlerInterceptor中的方法（posHandle））
     *     4.执行视图渲染操作（view层的内容）
     *     5.执行处理器完成后方法（自定义创建的拦截器中重写HandlerInterceptor中的方法（afterCompletion））
     * </p>
     * @param registry
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        //注册拦截器到SpringMvc机制中，然后它会返回一个拦截器注册
//        InterceptorRegistration ir = registry.addInterceptor(new MyInterceptor());
//        //指定拦截匹配模式，限制拦截器拦截请求
//        ir.addPathPatterns("/interceptor/*");
//    }

    /**
     * 测试注册多个拦截器操作
     * <p>
     *     多个拦截器执行顺序：
     *     1.依次执行处理器1、2、3的前方法(preHandle)
     *     2.执行处理器逻辑方法（控制器（controller）中的方法）
     *     3.依次(倒序)执行处理器3、2、1的后方法(posHandle)
     *     4.执行视图渲染(view)操作
     *     5.依次(倒序)执行处理器3、2、1的完成方法(afterCompletion)
     * </p>
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //注册拦截器到SpringMvc机制中，然后它会返回一个拦截器注册
        InterceptorRegistration ir1 = registry.addInterceptor(new Interceptor1());
        //指定拦截匹配模式，限制拦截器拦截请求
        ir1.addPathPatterns("/interceptor/*");

        InterceptorRegistration ir2 = registry.addInterceptor(new Interceptor2());
        ir2.addPathPatterns("/interceptor/*");

        InterceptorRegistration ir3 = registry.addInterceptor(new Interceptor3());
        ir3.addPathPatterns("/interceptor/*");
    }

}
