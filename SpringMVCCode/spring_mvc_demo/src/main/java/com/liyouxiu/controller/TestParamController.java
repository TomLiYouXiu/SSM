package com.liyouxiu.controller;

import com.liyouxiu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author liyouxiu
 * @date 2022/10/8 17:16
 *
 * 获取请求参数的方式
 * 1.通过servletAPI的方式获取
 * 只需要在控制器方法的形参位置设置HttpServletRequest类型的形参
 * 就可以在控制器方法中使用request对象获取请求参数
 *
 * 2.通过控制器方法的形参获取
 * 只需要在控制器方法的形参位置，设置一个形参，形参的名字和请求参数的名字一直即可
 */
@Controller
public class TestParamController {

    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request) {
        //创建cookie
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(
            @RequestParam(value = "userName",required = false,defaultValue = "hello") String username,
                           String password,
            @RequestHeader("referer") String referer,
            //获取cookie
            @CookieValue("JSESSIONID") String jsessionId
    ){
        System.out.println("jsessionId"+jsessionId);
        System.out.println("username:"+username+",password:"+password+referer);
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/TestServletAPI")
    public String TestServletAPI(HttpServletRequest request){
        request.setAttribute("testScope","hello servletAPI");
        return "success";
    }
}


