package com.liyouxiu.spring.controller;

import com.liyouxiu.spring.service.UserService;

/**
 * @author liyouxiu
 * @date 2022/9/30 14:57
 */
public class UserController  {
    private UserService  userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
         userService.saveUser();
    }
}
