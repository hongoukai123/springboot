package com.kai.chap.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义简单拦截器
 * <p>
 *     实现HandlerInterceptor并且覆盖其方法即可
 * </p>
 * <p>
 *     有了这个拦截器SpringMVC并不会发现它，它还需要进行注册
 *     才能够拦截处理器，因此需要在***Application.java配置文
 *     件中实现WebMvcConfigurer接口，最后覆盖其addInterceptors方法
 *     进行注册拦截器
 * </p>
 * @author hok
 * @since 2019-3-25 18:16:54
 */
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 重写HandlerInterceptor中的preHandle
     * <p>
     *     处理器执行前的方法
     * </p>
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("处理器前的方法");
        //返回true不会拦截后续处理
//        return true;
        //如果改为false则只执行本方法（后续控制器、处理器后的方法、视图、处理器完成后的方法统统不执行）
        return false;
    }

    /**
     * 重写HandlerInterceptor中的postHandle方法
     * <p>
     *     处理器处理后的方法
     * </p>
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                    @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("处理器后方法");
    }

    /**
     * 重写HandlerInterceptor中的afterCompletion方法
     * <p>
     *     处理器完成后方法
     * </p>
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                         @Nullable Exception ex) throws Exception {
        System.out.println("处理器完成方法");
    }

}
