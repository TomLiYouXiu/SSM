package com.liyouxiu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author liyouxiu
 * @date 2022/10/10 15:37
 *
 * 查询所有的用户信息---->/user---->get
 * 根据ID查询用户信息---->/user/1---->get
 * 新增用户信息---->/user---->post
 * 修改用户信息---->/user---->put
 * 删除用户信息---->/user/1---->delete
 *
 */
@Controller
public class TestRestController {

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有的用户信息---->/user---->get");
        return "success";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") String id){
        System.out.println("根据ID查询用户信息---->/user/"+id+"---->get");
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String insertUser(){
        System.out.println("新增用户信息---->/user---->post");
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(){
        System.out.println("修改用户信息---->/user---->put");
        return "success";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") String id){
        System.out.println("删除用户信息---->/user/"+id+"---->delete");
        return "success";
    }

}
