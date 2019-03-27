package com.kai.chap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
@SpringBootApplication(scanBasePackages = "com.kai.chap")
public class Chapter12InternationalizationApplication implements WebMvcConfigurer {

    /**
     * 国际化拦截器
     */
    private LocaleChangeInterceptor lci;

    /**
     * 国际化解析器
     * 这个Bean的那么属性必须为localeResolver
     * @return
     */
    @Bean(name = "localeResolver")
    public LocaleResolver initLocaleResolver(){
        //从session中读取国际化
        SessionLocaleResolver slr = new SessionLocaleResolver();
        //默认国际化区域
        slr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return slr;
    }

    /**
     * 创建国际化拦截器
     * @return
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        if(lci != null) return lci;
        lci = new LocaleChangeInterceptor();
        //设置参数名（拦截器将读取HTTP请求为language的参数）
        lci.setParamName("language");
        return lci;
    }

    /**
     * 给处理器增加国际化拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //这里将通过国际化拦截器的preHandle方法对请求的国际化区域参数进行修改
        registry.addInterceptor(localeChangeInterceptor());
    }


    public static void main(String[] args) {
        SpringApplication.run(Chapter12InternationalizationApplication.class, args);
    }

}
