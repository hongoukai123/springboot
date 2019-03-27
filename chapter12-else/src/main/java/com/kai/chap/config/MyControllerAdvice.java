package com.kai.chap.config;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 控制器通知类
 * <p>
 *      @ControllerAdvice 注解标明这是一个控制器通知类，这个注解也标注了@Controller,
 *      所以此类也会在SpringIOC启动中自动扫描和装配。它的配置项basePackages配置的是包名
 *      限制，也就是说符合该配置的包的控制器才会被这个控制器通知所拦截，而annotations的配
 *      置项则是在原有包名限定的基础上再添加被标注为@Controller的类才会被拦截。
 * </p>
 * @author hok
 * @since 2019-3-27 14:39:03
 */
@ControllerAdvice(
        //指定拦截的包
        basePackages = {"com.kai.chap.controller.advice.*"},
        //限定被标注为@Controller的类才被拦截
        annotations = Controller.class
)
public class MyControllerAdvice {

    /**
     * 绑定格式化、参数转换规则和增加验证器等
     * <p>
     *      @InitBinder 是一个在控制器参数转换前被执行的代码，
     *      这里的WebDataBinder参数对象是SpringMVC会自动生成的参数，
     *      这里定义了日期类型的参数，采用了限定格式“yyyy-MM-dd”,则
     *      不再需要加入@DateTimeFormat对格式再进行指定，直接采用
     *      “yyyy-MM-dd”格式传递日期参数即可
     * </p>
     * @param binder
     */
    @InitBinder
    public void initDataBinder(WebDataBinder binder){
        //自定义日志编辑器，限定格式为yyyy-MM-dd,且参数不允许为空
        CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false);
        //注册自定义日期编辑器
        binder.registerCustomEditor(Date.class, dateEditor);
    }

    /**
     * 在执行控制器之前执行，可以初始化数据模型
     * <p>
     *      @ModelAttribute 是一个数据模型的注解。它在执行控制器方法前被执行，
     *      代码中增加了一个工程名称（project_name）的字符串，因此可以在控制器方法中获取它。
     * </p>
     * @param model
     */
    @ModelAttribute
    public void projectModel(Model model){
        model.addAttribute("project_name", "chapter12-else");
    }

    /**
     * 异常处理，使得被拦截的控制器方法发生异常时，都能用相同的视图响应
     * <p>
     *      @ExceptionHandler 中配置了Exception,它可以拦截所有控制器发生的异常。
     *      这里的Exception参数是SpringMVC执行控制器发生异常时传递的，而在方法中，
     *      给数据模型添加了异常信息，然后返回一个字符串exception，这个字符就指向了
     *      对应的jsp视图
     * </p>
     * @param model
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public String exception(Model model, Exception e){
        //给数据模型增加异常消息
        model.addAttribute("exception_message", e.getMessage());
        //返回异常视图
        return "exception";
    }

}
