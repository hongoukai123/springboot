package com.kai.chap.controller;

import com.kai.chap.pojo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 测试Session的两个注解@SessionAttributes和@SessionAttribute
 * <p>
 *     其中@SessionAttributes是作用于类上面（类注解），它会将相关数据模型的属性保存到Session中；
 * </p>
 * <p>
 *     其中@SessionAttribute应用于方法（参数）它的作用是将HttpSession中的属性读出，赋予控制器的参数；
 * </p>
 */
@SessionAttributes(names = {"userInfo"}, types = Long.class)
@Controller
@RequestMapping("/session")
public class SessionController {

    @RequestMapping("/show")
    public String show(){
        return "session";
    }

    @RequestMapping("/test")
    public String test(@SessionAttribute("id") Long id, Model model){
        //根据类型保存到session中
        model.addAttribute("id_new", id);
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setUserName("李四");
        userInfo.setNote("lisi");
        model.addAttribute("userInfo", userInfo);
        return "test";
    }

}
