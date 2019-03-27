package com.kai.chap.controller;

import com.kai.chap.pojo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @RequestMapping("/index")
    public String index(Long id){
        System.out.println("这里是index参数为：" + id);
        return "index";
    }

    /**
     * 获取json数据
     * <p>
     *     方法加入注解@ResponseBody，说明将此方法的结果转变为JSON数据集
     * </p>
     * <p>
     *     SpringMVC如何做到：在进入控制器方法前，当遇到标注@ResponseBody后，处理器
     *     就会记录这个方法的响应类型为JSON数据集。当执行完控制器返回后，处理器会启用
     *     结果解析器(ResultResolver)会解析这个结果，它会轮询注册给SpringMVC的HttpMessageConverter
     *     接口的实现类。因为MappingJackson2HttpMessageConverter这个实现类已经被SpringMVC所注册，加
     *     上SpringMVC将控制器的结果类型标注为JSON，所以就匹配上了，于是通过它就在处理器内部把结果转换为
     *     JSON。如果轮询不到匹配的HttpMessageConverter，那么就交由SpringMVC后续流程处理。
     * </p>
     * @return
     */
    @RequestMapping("/find")
    @ResponseBody
    public Map<String, Object> getMapUserInfo(){
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1001);
        map.put("msg", "访问成功");
        map.put("result", "张三");
        return map;
    }

    /**
     * 重定向测试
     * 传递字符串类型参数
     * <p>
     *     在返回结果中使用redirect:加上路由地址及参数
     * </p>
     * @return
     */
    @RequestMapping("/red1")
    public String redirect1(){
        Long id = 1L;
        return "redirect:/user/index?id=" + id;
    }

    @RequestMapping("/show")
    @ResponseBody
    public Map<String,Object> show(UserInfo userInfo){
        Map<String, Object> map = new HashMap<>();
        map.put("user", userInfo);
        return map;
    }

    /**
     * 重定向（对象）
     * <p>
     *     要重定向传递对象，则需要设置参数RedirectAttributes;
     *     然后调用其中的方法addFlashAttributes保存对象参数，在控制器执行完成后，会
     *     被保存到session对象中，当执行重定向时，在进入重定向前首先把session中的参数
     *     取出，用以填充重定向方法的参数和数据模型，之后删除Session中的数据，然后调用
     *     重定向方法，并将对象传递给重定向方法。
     * </p>
     * @param ra
     * @return
     */
    @RequestMapping("/red2")
    public String redirect2(RedirectAttributes ra){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(101L);
        userInfo.setUserName("张三");
        userInfo.setNote("zhangsan");
        //保存需要传递给重定向的对象
        ra.addFlashAttribute("userInfo", userInfo);
        return "redirect:/user/show";
    }

}
