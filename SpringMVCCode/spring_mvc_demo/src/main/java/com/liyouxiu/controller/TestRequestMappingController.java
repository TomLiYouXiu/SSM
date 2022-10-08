package com.liyouxiu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author liyouxiu
 * @date 2022/10/7 16:07
 *
 *1.
 * @RequestMapping标识一个类：设置映射请求的请求路径的初始信息
 * @RequestMapping标识一个方法：设置映射请求请求路径的具体信息
 *
 * 2.
 *  @RequestMapping 注解value属性
 *  作用：通过请求的请求路径匹配请求
 *  value属性是数组类型，即当前浏览器所发送的请求路径匹配的value属性中的任何一个值
 *  则当前请求就会被注解所标识的方法进行处理
 *
 *  3.
 *  @RequestMapping 注解method属性
 *  作用：通过请求的请求方式匹配请求
 *  method属性是RequestMethod类型的数组，即当前浏览器所发送的请求方式的method属性中的任何一个请求方式
 *  则当前请求就会被注解所标识的方法进行处理
 *  若浏览器所发送的请求请求路径匹配，但是请求方式不匹配则报错如下
 *  405：Request method 'POST' not supported
 *
 *  4.
 *  在@RequestMapping的基础上，结合请求方式的一些派生注解
 *  @GetMapping,@PostMapping,@DeleteMapping,@PutMapping
 *
 *  5.
 *  @RequestMapping注解的params属性
 *  作用：通过请求的参数匹配请求，即浏览器发送的请求的请求参数必须满足params属性的设置
 *  params可以使用四种表达式
 *  “params”：表示当前所匹配请求参数中必须携带param参数
 *  “!params”：表示当前所匹配请求参数中一定不能携带param参数
 *  “params=value”：表示当前所匹配请求参数中必须携带param参数且值必须为value
 *  “params!=value”：表示当前所匹配请求参数中可以不携带param参数，但是若携带值不能是value
 */
@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {

    //此时控制器的方法所匹配的请求路径为/test/hello
    @RequestMapping(
            value = {"/hello","/abc"},
//            method = {RequestMethod.POST,RequestMethod.GET},
//            params = {"username","!password","age=20"}
            headers = {"referer"}
    )
    public String hello(){
        return "success";
    }

    @RequestMapping("/a?a/test/ant")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/test/rest/1")
    public String testRest(){

        return "success";
    }
}
