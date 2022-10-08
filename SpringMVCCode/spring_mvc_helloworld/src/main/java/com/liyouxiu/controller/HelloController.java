package com.liyouxiu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liyouxiu
 * @date 2022/10/7 10:54
 */
@Controller
public class HelloController {
    //@RequestMapping 注解：处理请求和控制器之间的映射关系
    //@RequestMapping注解的value属性可以通过请求地址匹配请求，/ 表示的当前工程的上下文路径
    @RequestMapping("/")
    public String protal(){
        //将逻辑视图返回
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }
}
