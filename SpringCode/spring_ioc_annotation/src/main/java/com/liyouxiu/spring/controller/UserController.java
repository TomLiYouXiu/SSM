package com.liyouxiu.spring.controller;

import com.liyouxiu.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author liyouxiu
 * @date 2022/9/30 21:12
 */
@Controller
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

//    public UserService getUserService() {
//        return userService;
//    }
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    public void saveUser(){
        userService.saveUser();
    }

}
