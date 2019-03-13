package com.kai.chap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 开发控制器
 * @author hok
 * @since 2019-3-6 18:10:41
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}
