package com.liyouxiu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liyouxiu
 * @date 2022/10/7 16:09
 */
@Controller
public class ProtalController {
    @RequestMapping("/")
    public String protal(){
        return "index";
    }
}
