package com.kai.chap.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器1
 * <p>
 *     为了测试多个拦截器，之间调用的顺序
 * </p>
 */
public class Interceptor1 implements HandlerInterceptor {

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
        //使用反射获取当前类的名称
        System.out.println("【" + this.getClass().getSimpleName() + "】处理器前的方法");
        //返回true不会拦截后续处理
        return true;
        //如果改为false则只执行本方法（后续控制器、处理器后的方法、视图、处理器完成后的方法统统不执行）
//        return false;
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
        System.out.println("【" + this.getClass().getSimpleName() + "】处理器后方法");
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
        System.out.println("【" + this.getClass().getSimpleName() + "】处理器完成方法");
    }

}
