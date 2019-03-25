package com.kai.chap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传控制器
 * @author hok
 * @since 2019-3-25 16:06:42
 */
@Controller
@RequestMapping("/file")
public class FileController {

    /**
     * 打开文件上传请求的页面
     * @return
     */
    @GetMapping("/upload/page")
    public String uploadPage(){
        return "upload";
    }

    /**
     * 第一种：上传文件
     * 使用HttpServletRequest作为参数
     * @param request
     * @return
     */
    @PostMapping("/upload/request")
    @ResponseBody
    public Map<String, Object> uploadRequest(HttpServletRequest request){
        MultipartHttpServletRequest mhsr = null;
        //强制将request转换成MultipartHttpServletRequest接口对象
        if (request instanceof MultipartHttpServletRequest){
            mhsr = (MultipartHttpServletRequest) request;
        }else{
            return resultMap(false, "上传失败");
        }
        //获取MultipartFile文件信息
        MultipartFile mf = mhsr.getFile("file");
        //获取源文件名称
        String fileName = mf.getOriginalFilename();
        File file = new File(fileName);
        try {
            //保存文件
            mf.transferTo(file);
        }catch (Exception e){
            e.printStackTrace();
            return resultMap(false, "上传失败");
        }
        return resultMap(true, "上传成功");
    }

    /**
     * 第二种：文件上传
     * 使用SpringMVC的MultipartFile类作为参数
     * @param file
     * @return
     */
    @PostMapping("/upload/multipart")
    @ResponseBody
    public Map<String, Object> uploadMultipartFile(MultipartFile file){
        String fileName = file.getOriginalFilename();
        File dest = new File(fileName);
        try {
            file.transferTo(dest);
        }catch (Exception e){
            e.printStackTrace();
            return resultMap(false, "上传失败");
        }
        return resultMap(true, "上传成功");
    }

    /**
     * 第三种：文件上传（强烈推荐使用）
     * 使用servlet的API（Part）来进行文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload/part")
    @ResponseBody
    public Map<String, Object> uploadPart(Part file){
        //获取提交文件的名称
        String fileName = file.getSubmittedFileName();
        try {
            file.write(fileName);
        }catch (Exception e){
            e.printStackTrace();
            return resultMap(false, "上传失败");
        }
        return resultMap(true, "上传成功");
    }

    /**
     * 响应结果
     * @param success
     * @param msg
     * @return
     */
    private Map<String, Object> resultMap(boolean success, String msg){
        Map<String, Object> map = new HashMap<>();
        map.put("success", success);
        map.put("msg", msg);
        return map;
    }

}
