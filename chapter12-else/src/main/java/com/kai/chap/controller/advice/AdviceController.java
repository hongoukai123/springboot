package com.kai.chap.controller.advice;

import com.kai.chap.utils.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * 测试控制器通知
 * @author hok
 * @since 2019-3-27 16:32:10
 */
@Controller
@RequestMapping("/advice")
public class AdviceController {

    @GetMapping("/test")
    public String test(Date date, ModelMap modelMap){
        //从数据模型中取数据
        System.out.println(modelMap.get("project_name"));
        //打印日期参数
        System.out.println(DateUtils.format(date, "yyyy-MM-dd"));
        //抛出异常这样流转到控制器异常通知
        throw new RuntimeException("异常了，跳转到控制器通知的异常信息里");
    }

}
