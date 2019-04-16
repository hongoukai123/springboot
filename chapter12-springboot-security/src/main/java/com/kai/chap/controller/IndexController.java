package com.kai.chap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器
 * @author hok
 * @since 2019-4-12 13:57:28
 */
@Controller
@RequestMapping("index")
public class IndexController {

    @RequestMapping("/list")
    public String index(){
        return "index";
    }

}
